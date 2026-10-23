package uz.ttpu.portfolio.otabek.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import uz.ttpu.portfolio.otabek.data.PortfolioContent
import uz.ttpu.portfolio.otabek.data.Project
import uz.ttpu.portfolio.otabek.ui.components.LocalWidthClass
import uz.ttpu.portfolio.otabek.ui.components.ProjectCard
import uz.ttpu.portfolio.otabek.ui.components.ProjectCardVariant
import uz.ttpu.portfolio.otabek.ui.components.gridColumns

@Composable
fun ProjectsScreen(
    modifier: Modifier = Modifier,
    projects: List<Project> = PortfolioContent.portfolio.projects,
) {
    val uriHandler = LocalUriHandler.current
    LazyVerticalGrid(
        columns = GridCells.Fixed(LocalWidthClass.current.gridColumns()),
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(projects) { project ->
            ProjectCard(
                project = project,
                onClick = { runCatching { uriHandler.openUri(project.repoUrl) } },
                variant = if (project.featured) ProjectCardVariant.Featured else ProjectCardVariant.Default,
                modifier = Modifier.heightIn(min = 140.dp),
            )
        }
    }
}