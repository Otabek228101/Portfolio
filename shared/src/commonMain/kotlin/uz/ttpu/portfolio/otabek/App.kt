package uz.ttpu.portfolio.otabek

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import uz.ttpu.portfolio.otabek.navigation.AppNavigation
import uz.ttpu.portfolio.otabek.ui.theme.PortfolioTheme
import uz.ttpu.portfolio.otabek.ui.theme.ThemeMode
import uz.ttpu.portfolio.otabek.ui.theme.ThemePreferences

@Composable
fun App() {
    val prefs = remember { ThemePreferences() }
    var themeMode by remember { mutableStateOf(prefs.load()) }

    val isDark = when (themeMode) {
        ThemeMode.System -> isSystemInDarkTheme()
        ThemeMode.Light -> false
        ThemeMode.Dark -> true
    }

    PortfolioTheme(darkTheme = isDark) {
        AppNavigation(
            isDark = isDark,
            onToggleTheme = {
                val newMode = if (isDark) ThemeMode.Light else ThemeMode.Dark
                themeMode = newMode
                prefs.save(newMode)
            },
        )
    }
}