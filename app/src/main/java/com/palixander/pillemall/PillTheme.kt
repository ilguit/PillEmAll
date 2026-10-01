package com.palixander.pillemall

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/** Red brand accents shared by actions and screen decoration. */
object PillColors {
    val button = Color(0xFFAE3028)
    val onButton = Color(0xFFFFF9F1)
    val success: Color
        @Composable get() = MaterialTheme.colorScheme.onSurfaceVariant
    val warning: Color
        @Composable get() = if (isSystemInDarkTheme()) Color(0xFFF0C875) else Color(0xFF795208)
}

object PillTypography {
    val time = TextStyle(fontFamily = FontFamily.Monospace, fontSize = 36.sp,
        lineHeight = 40.sp, fontWeight = FontWeight.Bold, letterSpacing = (-2).sp)
}

private val DarkPillColors = darkColorScheme(
    primary = Color(0xFFFF6B6B), onPrimary = Color(0xFF240606),
    primaryContainer = Color(0xFF452323), onPrimaryContainer = Color(0xFFFFDAD5),
    inversePrimary = Color(0xFFAE3028),
    secondary = Color(0xFFBCB6AD), onSecondary = Color(0xFF242321),
    secondaryContainer = Color(0xFF393530), onSecondaryContainer = Color(0xFFF2EEE5),
    tertiary = Color(0xFFFF6B6B), onTertiary = Color(0xFF240606),
    tertiaryContainer = Color(0xFF452323), onTertiaryContainer = Color(0xFFFFDAD5),
    background = Color(0xFF141414), onBackground = Color(0xFFF2EEE5),
    surface = Color(0xFF202020), onSurface = Color(0xFFF2EEE5),
    surfaceVariant = Color(0xFF302C28), onSurfaceVariant = Color(0xFFBCB6AD),
    surfaceTint = Color.Transparent,
    inverseSurface = Color(0xFFF3F0E9), inverseOnSurface = Color(0xFF242321),
    surfaceDim = Color(0xFF141414), surfaceBright = Color(0xFF393530),
    surfaceContainerLowest = Color(0xFF101010), surfaceContainerLow = Color(0xFF1B1A19),
    surfaceContainer = Color(0xFF202020), surfaceContainerHigh = Color(0xFF2B2926),
    surfaceContainerHighest = Color(0xFF36322E),
    outline = Color(0xFF8D867D), outlineVariant = Color(0xFF45413C),
    error = Color(0xFFFFB4AB), onError = Color(0xFF690005),
    errorContainer = Color(0xFF650F13), onErrorContainer = Color(0xFFFFDAD6),
    scrim = Color.Black
)

private val LightPillColors = lightColorScheme(
    primary = Color(0xFFAE3028), onPrimary = Color(0xFFFFF9F1),
    primaryContainer = Color(0xFFF5DDD5), onPrimaryContainer = Color(0xFF7F201B),
    inversePrimary = Color(0xFFFF6B6B),
    secondary = Color(0xFF666159), onSecondary = Color(0xFFFFFDF8),
    secondaryContainer = Color(0xFFE8E1D7), onSecondaryContainer = Color(0xFF393530),
    tertiary = Color(0xFFAE3028), onTertiary = Color(0xFFFFF9F1),
    tertiaryContainer = Color(0xFFF5DDD5), onTertiaryContainer = Color(0xFF7F201B),
    background = Color(0xFFF3F0E9), onBackground = Color(0xFF242321),
    surface = Color(0xFFFFFDF8), onSurface = Color(0xFF242321),
    surfaceVariant = Color(0xFFECE6DC), onSurfaceVariant = Color(0xFF666159),
    surfaceTint = Color.Transparent,
    inverseSurface = Color(0xFF242321), inverseOnSurface = Color(0xFFF2EEE5),
    surfaceDim = Color(0xFFE1DBD2), surfaceBright = Color(0xFFFFFDF8),
    surfaceContainerLowest = Color(0xFFFFFDF8), surfaceContainerLow = Color(0xFFF8F5EF),
    surfaceContainer = Color(0xFFF3F0E9), surfaceContainerHigh = Color(0xFFEDE8DF),
    surfaceContainerHighest = Color(0xFFE6E0D6),
    outline = Color(0xFF81796F), outlineVariant = Color(0xFFD4CFC6),
    error = Color(0xFFBA1A1A), onError = Color.White,
    errorContainer = Color(0xFFFFDAD6), onErrorContainer = Color(0xFF690005),
    scrim = Color.Black
)

private val PillText = Typography(
    headlineLarge = TextStyle(fontSize = 32.sp, lineHeight = 38.sp, fontWeight = FontWeight.Bold),
    headlineSmall = TextStyle(fontSize = 22.sp, lineHeight = 28.sp, fontWeight = FontWeight.Bold),
    titleLarge = TextStyle(fontSize = 21.sp, lineHeight = 27.sp, fontWeight = FontWeight.Bold),
    titleMedium = TextStyle(fontSize = 17.sp, lineHeight = 23.sp, fontWeight = FontWeight.SemiBold),
    bodyLarge = TextStyle(fontSize = 16.sp, lineHeight = 23.sp),
    bodyMedium = TextStyle(fontSize = 14.sp, lineHeight = 20.sp),
    bodySmall = TextStyle(fontSize = 13.sp, lineHeight = 19.sp),
    labelLarge = TextStyle(fontSize = 14.sp, lineHeight = 20.sp, fontWeight = FontWeight.SemiBold)
)

@Composable
fun PillTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) DarkPillColors else LightPillColors,
        typography = PillText,
        shapes = Shapes(
            extraSmall = RoundedCornerShape(5.dp), small = RoundedCornerShape(8.dp),
            medium = RoundedCornerShape(10.dp), large = RoundedCornerShape(12.dp),
            extraLarge = RoundedCornerShape(16.dp)
        ),
        content = content
    )
}

/** Keep disabled colors supplied by Material; use these on the button, not its label. */
object PillActionColors {
    @Composable fun neutral() = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colorScheme.onSurfaceVariant)
    @Composable fun confirm() = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colorScheme.tertiary)
    @Composable fun destructive() = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colorScheme.error)
    @Composable fun confirmTonal() = ButtonDefaults.filledTonalButtonColors(
        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        contentColor = MaterialTheme.colorScheme.onTertiaryContainer
    )
}

/** Native date/time pickers follow the same action roles as Compose dialogs. */
fun android.app.AlertDialog.showWithActionColors() {
    show()
    val dark = context.resources.configuration.uiMode and
        android.content.res.Configuration.UI_MODE_NIGHT_MASK == android.content.res.Configuration.UI_MODE_NIGHT_YES
    val colors = if (dark) DarkPillColors else LightPillColors
    getButton(android.content.DialogInterface.BUTTON_POSITIVE)?.setTextColor(colors.tertiary.toArgb())
    getButton(android.content.DialogInterface.BUTTON_NEGATIVE)?.setTextColor(colors.onSurfaceVariant.toArgb())
}
