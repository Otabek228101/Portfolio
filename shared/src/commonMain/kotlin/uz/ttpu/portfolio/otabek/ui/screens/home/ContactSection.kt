package uz.ttpu.portfolio.otabek.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.TextButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import uz.ttpu.portfolio.otabek.data.SocialLink
import uz.ttpu.portfolio.otabek.ui.components.SectionTitle

@Composable
fun ContactSection(links: List<SocialLink>, modifier: Modifier = Modifier) {
    val uriHandler = LocalUriHandler.current
    Column(modifier) {
        SectionTitle("Contact")
        links.forEach { link ->
            TextButton(onClick = { runCatching { uriHandler.openUri(link.url) } }) {
                Text(link.label)
            }
        }
    }
}