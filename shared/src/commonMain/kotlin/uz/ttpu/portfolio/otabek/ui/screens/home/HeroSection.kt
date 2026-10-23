package uz.ttpu.portfolio.otabek.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.ttpu.portfolio.otabek.data.Bio
import uz.ttpu.portfolio.otabek.ui.components.LocalWidthClass
import uz.ttpu.portfolio.otabek.ui.components.WidthClass
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.ExperimentalLayoutApi
@Composable
fun HeroSection(
    bio: Bio,
    onViewProjects: () -> Unit,
    onContact: () -> Unit,
    modifier: Modifier = Modifier,
) {
    if (LocalWidthClass.current == WidthClass.Expanded) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            HeroText(bio, Modifier.weight(1f))
            HeroButtons(onViewProjects, onContact)
        }
    } else {
        Column(modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {
            HeroText(bio)
            HeroButtons(onViewProjects, onContact)
        }
    }
}

@Composable
private fun HeroText(bio: Bio, modifier: Modifier = Modifier) {
    Column(modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(bio.name, style = MaterialTheme.typography.displaySmall)
        Text(bio.role, style = MaterialTheme.typography.titleMedium)
        Text(bio.tagline, style = MaterialTheme.typography.bodyLarge)
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun HeroButtons(onViewProjects: () -> Unit, onContact: () -> Unit) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Button(onClick = onViewProjects) { Text("View projects") }
        OutlinedButton(onClick = onContact) { Text("Contact me") }
    }
}