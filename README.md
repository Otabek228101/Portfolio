# Otabek Portfolio

A personal portfolio app built with `Kotlin Multiplatform` and `Compose Multiplatform`.
One shared UI codebase runs on **Android** and **iOS**, fully offline.

**Release:** [v1.0.0](https://github.com/Otabek228101/Portfolio/releases/tag/v1.0.0) - Android APK and iOS Simulator build, created by GitHub Actions.

## Screenshots

| | Light                                               | Dark                                              |
| --- |-----------------------------------------------------|---------------------------------------------------|
| Android | [Android light](docs/screenshots/android_light.png) | [Android dark](docs/screenshots/android_dark.png) |
| iOS | I dont know                                         | how check without iphone                          |

Adaptive layout: [phone vertical](docs/screenshots/vertical.png), [phone horizontal](docs/screenshots/horizontal.png) , [tablet](docs/screenshots/tablet.png) , [largest font size](docs/screenshots/big_words.png)

## Build and run locally

Requirements: JDK 17+, Android Studio with the Kotlin Multiplatform plugin. For iOS: a Mac with Xcode.

**Android:**
```bash
git clone https://github.com/Otabek228101/Portfolio.git
cd Portfolio
./gradlew :androidApp:assembleDebug
adb install androidApp/build/outputs/apk/debug/androidApp-debug.apk
```

**Android (IDE):** open the project in Android Studio, select the `androidApp` run configuration and press Run.

**iOS:** open `iosApp/iosApp.xcodeproj` in Xcode, choose an iPhone simulator and press Run. Xcode builds the shared Kotlin framework automatically through Gradle.

## Architecture

| Decision | Reason |
| --- | --- |
| Shared UI with Compose Multiplatform instead of native UI per platform | One codebase for both platforms; the app is content-driven and needs no platform-specific UI |
| `commonMain` holds all UI, navigation, theme and data; `androidMain` / `iosMain` hold only what cannot be shared | Maximum code reuse; platform code stays small and easy to review |
| Content is typed Kotlin data (`data/PortfolioContent.kt`), not text inside composables | Changing content never touches UI code; typos in image names become compile errors |
| `expect`/`actual` for `platformName()` and `SystemBarsAppearance()` | The only places that need platform APIs (`Build.VERSION`, `UIDevice`, Android window insets controller) |
| Navigation: one `NavHost` in `navigation/AppNavigation.kt` with string routes, using the multiplatform Navigation Compose library | Navigation code lives in exactly one place; same back stack behavior on both platforms |
| Adaptive layout via `BoxWithConstraints` thresholds (600 / 840 dp) shared through a `CompositionLocal` | Measured once at the root; works identically on Android and iOS without extra dependencies |
| Theme mode persisted with Multiplatform Settings from `commonMain` | One API; stored in SharedPreferences on Android and NSUserDefaults on iOS |
| Images and font loaded through Compose Multiplatform resources | One resource folder in `commonMain` for both platforms |
| CI: GitHub Actions builds the APK on Ubuntu and the iOS Simulator app on macOS, then creates a Release on a `v*` tag | Every release is built from a clean machine, not from a developer laptop |

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

## When native UI would be better

If the app needed deep platform features such as home-screen widgets, Live Activities, Material You dynamic color or each platform's own navigation patterns, native SwiftUI and Jetpack Compose would give direct access to the newest platform UI APIs and a fully native look and feel.
A team with dedicated iOS and Android developers could also work faster in the toolkits they already know, while still sharing networking, data and business logic through Kotlin Multiplatform.
For a small, content-only portfolio like this one a single shared UI is simpler, but once each platform has to feel truly native, shared logic with native UI is the better trade-off.