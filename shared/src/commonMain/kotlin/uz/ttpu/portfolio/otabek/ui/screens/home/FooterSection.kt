package uz.ttpu.portfolio.otabek.ui.screens.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import uz.ttpu.portfolio.otabek.platformName

@Composable
fun FooterSection(modifier: Modifier = Modifier) {
    Text(
        text = "Running on ${platformName()}",
        style = MaterialTheme.typography.labelMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        textAlign = TextAlign.Center,
        modifier = modifier.fillMaxWidth(),
    )
}