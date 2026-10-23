package uz.ttpu.portfolio.otabek.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import uz.ttpu.portfolio.otabek.data.Portfolio
import uz.ttpu.portfolio.otabek.data.PortfolioContent
import uz.ttpu.portfolio.otabek.ui.screens.home.AboutSection
import uz.ttpu.portfolio.otabek.ui.screens.home.ContactSection
import uz.ttpu.portfolio.otabek.ui.screens.home.HeroSection
import uz.ttpu.portfolio.otabek.ui.screens.home.ProjectsSection
import uz.ttpu.portfolio.otabek.ui.screens.home.SkillsSection

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    portfolio: Portfolio = PortfolioContent.portfolio,
    onViewProjects: () -> Unit = {},
) {
    val uriHandler = LocalUriHandler.current
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp),
    ) {
        item {
            HeroSection(
                bio = portfolio.bio,
                onViewProjects = onViewProjects,
                onContact = {
                    portfolio.links.firstOrNull()?.let {
                        runCatching { uriHandler.openUri(it.url) }
                    }
                },
            )
        }
        item { AboutSection(portfolio.bio) }
        item { SkillsSection(portfolio.skills) }
        item { ProjectsSection(portfolio.projects) }
        item { ContactSection(portfolio.links) }
    }
}