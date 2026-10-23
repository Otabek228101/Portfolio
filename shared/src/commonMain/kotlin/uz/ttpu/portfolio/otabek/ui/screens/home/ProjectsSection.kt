package uz.ttpu.portfolio.otabek.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import uz.ttpu.portfolio.otabek.data.Project
import uz.ttpu.portfolio.otabek.ui.components.LocalWidthClass
import uz.ttpu.portfolio.otabek.ui.components.ProjectCard
import uz.ttpu.portfolio.otabek.ui.components.ProjectCardVariant
import uz.ttpu.portfolio.otabek.ui.components.SectionTitle
import uz.ttpu.portfolio.otabek.ui.components.gridColumns

@Composable
fun ProjectsSection(projects: List<Project>, modifier: Modifier = Modifier) {
    val uriHandler = LocalUriHandler.current
    val columns = LocalWidthClass.current.gridColumns()
    Column(modifier, verticalArrangement = Arrangement.spacedBy(12.dp)) {
        SectionTitle("Projects")
        projects.chunked(columns).forEach { row ->
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                row.forEach { project ->
                    ProjectCard(
                        project = project,
                        onClick = { runCatching { uriHandler.openUri(project.repoUrl) } },
                        variant = if (project.featured) ProjectCardVariant.Featured else ProjectCardVariant.Default,
                        modifier = Modifier.weight(1f),
                    )
                }
                repeat(columns - row.size) { Spacer(Modifier.weight(1f)) }
            }
        }
    }
}