package uz.ttpu.portfolio.otabek.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.ttpu.portfolio.otabek.data.Project
import uz.ttpu.portfolio.otabek.ui.components.SectionTitle

@Composable
fun ProjectsSection(projects: List<Project>, modifier: Modifier = Modifier) {
    Column(modifier, verticalArrangement = Arrangement.spacedBy(12.dp)) {
        SectionTitle("Projects")
        projects.forEach { project ->
            Column {
                Text(project.title, style = MaterialTheme.typography.titleMedium)
                Text(project.description, style = MaterialTheme.typography.bodyMedium)
                Text(
                    project.tags.joinToString(" · "),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary,
                )
            }
        }
    }
}