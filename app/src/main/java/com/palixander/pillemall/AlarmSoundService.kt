package com.palixander.pillemall

import android.app.Notification
import android.app.Service
import android.content.Intent
import android.content.pm.ServiceInfo
import android.media.AudioAttributes
import android.media.Ringtone
import android.media.RingtoneManager
import android.net.Uri
import android.os.IBinder

/** Owns alarm playback so System UI interactions cannot dismiss the sound. */
class AlarmSoundService : Service() {
    private var ringtone: Ringtone? = null
    private var scheduled: Long? = null

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val nextScheduled = intent?.getLongExtra(EXTRA_SCHEDULED, Long.MIN_VALUE)
            ?.takeUnless { it == Long.MIN_VALUE } ?: return START_NOT_STICKY
        startForeground(
            NOTIFICATION_ID,
            Notification.Builder(this, Reminders.CHANNEL)
                .setSmallIcon(R.drawable.ic_notification)
                .setColor(getColor(R.color.notification_accent))
                .setContentTitle(getString(R.string.reminder_title))
                .setOngoing(true)
                .setCategory(Notification.CATEGORY_ALARM)
                .setVisibility(Notification.VISIBILITY_PRIVATE)
                .build(),
            ServiceInfo.FOREGROUND_SERVICE_TYPE_MEDIA_PLAYBACK
        )

        if (scheduled != nextScheduled || ringtone?.isPlaying != true) {
            ringtone?.stop()
            scheduled = nextScheduled
            val requested = intent.getStringExtra(EXTRA_SOUND)?.let(Uri::parse)
            ringtone = loadRingtone(requested).apply {
                audioAttributes = AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_ALARM).build()
                isLooping = true
                play()
            }
        }
        return START_NOT_STICKY
    }

    private fun loadRingtone(requested: Uri?): Ringtone =
        requested?.let { runCatching { RingtoneManager.getRingtone(this, it) }.getOrNull() }
            ?: RingtoneManager.getRingtone(this, RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM))

    override fun onDestroy() {
        ringtone?.stop()
        ringtone = null
        scheduled = null
        super.onDestroy()
    }

    companion object {
        private const val ACTION_START = "com.palixander.pillemall.START_ALARM_SOUND"
        private const val EXTRA_SCHEDULED = "scheduled"
        private const val EXTRA_SOUND = "sound"
        private const val NOTIFICATION_ID = 2

        fun start(context: android.content.Context, scheduled: Long, sound: String?) {
            context.startForegroundService(Intent(context, AlarmSoundService::class.java).apply {
                action = ACTION_START
                putExtra(EXTRA_SCHEDULED, scheduled)
                sound?.let { putExtra(EXTRA_SOUND, it) }
            })
        }

        fun stop(context: android.content.Context, scheduled: Long? = null) {
            // Only one medication alarm can ring at a time; stopService also works
            // when the snooze action is handled while the app is in the background.
            context.stopService(Intent(context, AlarmSoundService::class.java))
        }
    }
}
