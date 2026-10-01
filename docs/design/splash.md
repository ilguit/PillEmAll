# Splash and cover viewer

Selected artwork: second preview from the final spacing adjustment, generated file
`exec-641b1448-685f-40c9-b69c-90b1e3078172.png`.
The restored PNG is stored in `app/src/main/res/drawable-nodpi/pill_cover.png`.

The native launch theme uses a black background and a 288 dp drawable. The complete
portrait occupies a centered 104 × 156 dp rectangle (187.49 dp diagonal), entirely
inside Android's 192 dp safe circle. No artificial launch delay is added.
Reference: https://developer.android.com/develop/ui/views/launch/splash-screen

Tapping the header wordmark opens a full-window dialog. ContentScale.Fit preserves
the artwork and its original spacing, with black letterboxing on other aspect
ratios. System bars hide in the dialog; tapping anywhere or using Back dismisses it.
The activity's window is not modified by the viewer. Header artwork width is 2/3
of its previous width, retaining a minimum 48 dp tap height.

Validation: debug build, unit tests, lint, and diff whitespace checks. Device-level
visual and gesture checks remain to be performed.

Hand-shadow restoration: imagegen edit `exec-35a57481-11bd-4cfb-8041-d7c19ecbfe71.png`, removing mottled texture and smoothing optical defocus while preserving the layout. Previous asset: `pill-cover-before-restoration.png`.
