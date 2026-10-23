package uz.ttpu.portfolio.otabek.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import uz.ttpu.portfolio.otabek.data.Project

enum class ProjectCardVariant { Default, Featured }

object ProjectCardDefaults {
    val ContentPadding = PaddingValues(16.dp)

    val shape: Shape
        @Composable get() = MaterialTheme.shapes.large

    @Composable
    fun containerColor(variant: ProjectCardVariant): Color = when (variant) {
        ProjectCardVariant.Default -> MaterialTheme.colorScheme.surfaceContainerLow
        ProjectCardVariant.Featured -> MaterialTheme.colorScheme.primaryContainer
    }

    @Composable
    fun contentColor(variant: ProjectCardVariant): Color = when (variant) {
        ProjectCardVariant.Default -> MaterialTheme.colorScheme.onSurface
        ProjectCardVariant.Featured -> MaterialTheme.colorScheme.onPrimaryContainer
    }

    @Composable
    fun border(variant: ProjectCardVariant): BorderStroke? = when (variant) {
        ProjectCardVariant.Default -> BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
        ProjectCardVariant.Featured -> null
    }

    fun elevation(variant: ProjectCardVariant): Dp = when (variant) {
        ProjectCardVariant.Default -> 0.dp
        ProjectCardVariant.Featured -> 4.dp
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProjectCard(
    project: Project,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    variant: ProjectCardVariant = ProjectCardVariant.Default,
) {
    Card(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = ProjectCardDefaults.shape,
        colors = CardDefaults.cardColors(
            containerColor = ProjectCardDefaults.containerColor(variant),
            contentColor = ProjectCardDefaults.contentColor(variant),
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = ProjectCardDefaults.elevation(variant)),
        border = ProjectCardDefaults.border(variant),
    ) {
        Column(
            modifier = Modifier.padding(ProjectCardDefaults.ContentPadding),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            if (variant == ProjectCardVariant.Featured) {
                Text("★ Featured", style = MaterialTheme.typography.labelMedium)
            }
            Text(project.title, style = MaterialTheme.typography.titleMedium)
            Text(project.description, style = MaterialTheme.typography.bodyMedium)
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                project.tags.forEach { Tag(it) }
            }
        }
    }
}