package uz.ttpu.portfolio.otabek.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.ttpu.portfolio.otabek.data.Portfolio
import uz.ttpu.portfolio.otabek.data.PortfolioContent

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    portfolio: Portfolio = PortfolioContent.portfolio,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .safeContentPadding(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        item {
            Text(portfolio.bio.name, style = MaterialTheme.typography.headlineMedium)
            Text(portfolio.bio.role)
        }

        item { Text("Projects", style = MaterialTheme.typography.titleMedium) }
        items(portfolio.projects) { project ->
            Text("${project.title}: ${project.tags.joinToString()}")
        }

        item { Text("Skills", style = MaterialTheme.typography.titleMedium) }
        items(portfolio.skills) { skill ->
            Text("${skill.name} (${skill.group.label})")
        }

        item { Text("Links", style = MaterialTheme.typography.titleMedium) }
        items(portfolio.links) { link ->
            Text("${link.label}: ${link.url}")
        }
    }
}