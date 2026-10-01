# Screens migration — step 1 handoff

Owner: screens_step1. Ready for a separate review agent.

## Changes

- Replaced activity inline Material theme with coordinated PillTheme.
- Added shared content-sized brand header for main tabs and notification entry, retaining title/date/close action.
- Applied warm neutral surfaces, subtle borders, angular corners inherited from theme, deep red #AE3028 primary button fills, outlined status badges (green taken, amber waiting, red missed, neutral planned/cancelled).
- Upcoming cards use 36sp monospace time, red top rule for waiting intake; notification entry displays scheduled time only when all displayed intake rows share it.
- Kept tab order, database and reminder operations, confirmation/editing/archive/delete flows, history long press, import/export and all resource strings. Brand text uses app_name.
- Form save is a primary button; fields fill available width; dialogs retain native scrolling and validation.
- Action rows, time/status area, and backup export/import wrap rather than clip at enlarged text. Backup expansion target is at least 48dp.

## Checks and remaining work

Reviewed diff for unchanged business callbacks and conditions. git diff --check passes after whitespace cleanup. Compile attempted but current shell lacks JAVA_HOME; parent owns integration Gradle invocation and has working Java setup. No screenshot claim: emulator/device visual QA remains for reviewer/root.

## Next reviewer instructions

Inspect MainActivity.kt and BackupControls.kt against approved HTML. Validate both system themes, narrow screen and enlarged fonts, long profile/medicine strings and translated dates, main tabs, first profile, prescription form, confirm dialog, permission warning, backup expansion and notification entry. Check theme symbols PillColors/PillTypography/PillTheme compile with theme agent output. Pay particular attention to existing profile/course action rows at large font scales. Preserve behavior and do not replace native real interactions with mockup demonstrations. Coordinate Gradle with root (no concurrent builds). Monochrome notification asset is outside this part and must remain unchanged.
