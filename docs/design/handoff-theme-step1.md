# Theme step 1 handoff

Implemented `PillTheme.kt` in the existing application package. `PillTheme(content)` selects the system light/dark theme; screen integration is owned by the screens agent. It supplies the mockup's charcoal/paper/ivory surfaces and warm neutral surface-container roles, compact 5/8/10/12/16dp shapes, and readable existing-sized typography.

Public API:
- `PillColors.button` = #AE3028; `PillColors.onButton` = #FFF9F1. Explicitly use these for filled action buttons, preserving the approved deep red in both themes.
- `MaterialTheme.colorScheme.primary` is #AE3028 in light mode and #FF6B6B in dark mode. The latter is a pure light red (equal green/blue), replacing mockup salmon, for readable links/control outlines. Deep red must not be used as small text on charcoal.
- `PillColors.success` / `warning` are composable getters for semantic statuses in the system theme. Always retain status text/icons.
- `PillTypography.time` is 36sp bold monospace; `PillTypography.brand` is 25sp Android condensed bold.

Native AppTheme light and night resources now have warm backgrounds, matching status/navigation appearance, and deep-red accents. Existing system date/time picker behavior remains native. All six localized app_name strings now read “Pill ’Em All”; other localized strings were preserved.

Checks: all values XML parses. Deep red filled button text contrast 6.17:1; light primary on ivory 6.35:1; dark primary on highest dark container 4.58:1 (higher on ordinary cards); muted dark text/card 8.09:1. Initial integration compilation identified String FontFamily overload; replaced with Android Typeface-backed FontFamily. Root will rerun Gradle compilation.

Next reviewer instructions: independently verify both schemes and dark text contrast, check compile/resource linking, inspect native picker visibility in both modes, ensure screens use button tokens for red fills, check system bars on edge-to-edge activity and ensure launcher/notification graphics were not touched by this step. No rendering or emulator checks performed here. Other agents own MainActivity and icon resources.
