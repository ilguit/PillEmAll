# Screens migration — step 2 review

Reviewed MainActivity.kt and BackupControls.kt after step 1 against approved pill-em-all.html. Review scope: layout robustness, callback preservation, theme integration and insets. Root owns compile/test/device checks.

## Changes

- Added AdaptiveDetailsRow for profile headers and active prescription rows. Existing inline action positions remain at normal widths. At content width below 300dp or font scale above 1.3, edit/delete/archive actions occupy a right-aligned second row, freeing width for names, doses and course dates. Callbacks and accessibility labels remain unchanged.
- Prescription time column maximum width now scales with font size, reducing broken clock strings at enlarged text sizes.
- Header uses top and horizontal safe-drawing insets so landscape display cutouts cannot obscure brand or close action; wrapped brand text is centered.
- BackupControls required no further edits: weighted section title, 48dp minimum expansion target and wrapping action buttons were already implemented by step 1.

## Evidence and limits

- git diff --check passes.
- Reviewed main tab order, reminder entry Scaffold padding, wrapped status/time/action regions, form validity and save conditions, repository mutation callbacks, backup export/import semantics. These remain intact.
- Palette, bordered cards, angular theme corners, monospace intake time, brand header and outline status tags follow the approved template; native dialogs and real action flows are retained.
- No notification icons or theme/icon resources changed in this step.
- No additional Gradle invocation or visual QA was performed by this agent; root handles integration build and device checks. Suggested checks: 320dp screen, 1.5–2x font, long profile/medicine names, Russian/Spanish, both themes, reminder close button and navigation inset.
