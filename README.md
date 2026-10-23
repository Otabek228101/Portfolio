## Platform differences

| Difference | Shared or platform-specific | How it is handled |
| --- | --- | --- |
| App icon | Platform-specific | Android: adaptive icon in `androidApp/src/main/res/mipmap-*` (Image Asset Studio). iOS: `AppIcon.appiconset/app-icon-1024.png` in `iosApp` |
| Display name | Platform-specific | Android: `app_name` in `strings.xml`. iOS: `CFBundleDisplayName` in `Info.plist` |
| Safe areas (notch, status bar, home indicator) | Shared | Android enables edge-to-edge in `MainActivity`; on both platforms the shared `Scaffold` and `NavigationRail` apply window insets |
| Status bar icon color | Platform-specific (expect/actual) | `SystemBarsAppearance(isDark)`: Android sets light/dark bar icons from the app theme; iOS follows the system appearance |
| Platform name in footer | Platform-specific (expect/actual) | `expect fun platformName()` in `commonMain`; `actual` uses `Build.VERSION` on Android and `UIDevice` on iOS |
| Theme persistence | Shared API | Multiplatform Settings in `commonMain`; stored in SharedPreferences on Android and NSUserDefaults on iOS |
| Opening links (mail, browser) | Shared API | `LocalUriHandler` in `commonMain`; opens the platform mail app or browser |
| Images and font | Shared | Compose Multiplatform resources in `commonMain/composeResources` |