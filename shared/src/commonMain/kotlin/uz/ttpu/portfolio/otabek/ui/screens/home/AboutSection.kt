package uz.ttpu.portfolio.otabek.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import uz.ttpu.portfolio.otabek.data.Bio
import uz.ttpu.portfolio.otabek.ui.components.SectionTitle

@Composable
fun AboutSection(bio: Bio, modifier: Modifier = Modifier) {
    androidx.compose.foundation.layout.Column(modifier) {
        SectionTitle("About")
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                Modifier
                    .size(72.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.surfaceVariant)
            )
            Text(bio.about, style = MaterialTheme.typography.bodyMedium)
        }
    }
}