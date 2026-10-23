package uz.ttpu.portfolio.otabek.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.ttpu.portfolio.otabek.data.Bio

@Composable
fun HeroSection(
    bio: Bio,
    onViewProjects: () -> Unit,
    onContact: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(bio.name, style = MaterialTheme.typography.displaySmall)
        Text(bio.role, style = MaterialTheme.typography.titleMedium)
        Text(bio.tagline, style = MaterialTheme.typography.bodyLarge)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = onViewProjects) { Text("View projects") }
            OutlinedButton(onClick = onContact) { Text("Contact me") }
        }
    }
}