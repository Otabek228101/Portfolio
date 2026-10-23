package uz.ttpu.portfolio.otabek.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun PortfolioTheme(
    darkTheme: Boolean,
    content: @Composable () -> Unit,
) {
    SystemBarsAppearance(isDark = darkTheme)
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = portfolioTypography(),
        content = content,
    )
}
