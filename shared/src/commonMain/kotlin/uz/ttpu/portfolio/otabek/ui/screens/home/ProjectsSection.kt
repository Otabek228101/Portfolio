package uz.ttpu.portfolio.otabek.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import uz.ttpu.portfolio.otabek.data.Project
import uz.ttpu.portfolio.otabek.ui.components.ProjectCard
import uz.ttpu.portfolio.otabek.ui.components.ProjectCardVariant
import uz.ttpu.portfolio.otabek.ui.components.SectionTitle

@Composable
fun ProjectsSection(projects: List<Project>, modifier: Modifier = Modifier) {
    val uriHandler = LocalUriHandler.current
    Column(modifier, verticalArrangement = Arrangement.spacedBy(12.dp)) {
        SectionTitle("Projects")
        projects.forEach { project ->
            ProjectCard(
                project = project,
                onClick = { runCatching { uriHandler.openUri(project.repoUrl) } },
                variant = if (project.featured) ProjectCardVariant.Featured else ProjectCardVariant.Default,
            )
        }
    }
}