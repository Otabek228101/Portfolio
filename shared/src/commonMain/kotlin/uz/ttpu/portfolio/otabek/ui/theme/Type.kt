package uz.ttpu.portfolio.otabek.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import portfolio.shared.generated.resources.Res
import portfolio.shared.generated.resources.cinzel_bold
import portfolio.shared.generated.resources.cinzel_regular

@Composable
fun portfolioTypography(): Typography {
    val cinzel = FontFamily(
        Font(Res.font.cinzel_regular, FontWeight.Normal),
        Font(Res.font.cinzel_bold, FontWeight.Bold),
    )
    val base = Typography()
    return base.copy(
        displayLarge = base.displayLarge.copy(fontFamily = cinzel, fontWeight = FontWeight.Bold),
        displayMedium = base.displayMedium.copy(fontFamily = cinzel, fontWeight = FontWeight.Bold),
        displaySmall = base.displaySmall.copy(fontFamily = cinzel, fontWeight = FontWeight.Bold),
        headlineMedium = base.headlineMedium.copy(fontFamily = cinzel),
        titleLarge = base.titleLarge.copy(fontFamily = cinzel, fontWeight = FontWeight.Bold),
        titleMedium = base.titleMedium.copy(fontFamily = cinzel),
    )
}