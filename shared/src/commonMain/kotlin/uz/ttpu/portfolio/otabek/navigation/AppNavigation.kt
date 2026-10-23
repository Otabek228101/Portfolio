package uz.ttpu.portfolio.otabek.navigation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import uz.ttpu.portfolio.otabek.data.PortfolioContent
import uz.ttpu.portfolio.otabek.ui.components.LocalWidthClass
import uz.ttpu.portfolio.otabek.ui.components.ProvideWidthClass
import uz.ttpu.portfolio.otabek.ui.components.WidthClass
import uz.ttpu.portfolio.otabek.ui.screens.HomeScreen
import uz.ttpu.portfolio.otabek.ui.screens.ProjectsScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation(isDark: Boolean,onToggleTheme: () -> Unit,) {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route


    val navigateTo: (String) -> Unit = { route ->
        navController.navigate(route) {
            popUpTo(Routes.HOME) { saveState = true }
            launchSingleTop = true
            restoreState = true
        }
    }

    ProvideWidthClass {
        val useRail = LocalWidthClass.current != WidthClass.Compact
        Row(Modifier.fillMaxSize()) {
            if (useRail) AppNavRail(currentRoute, navigateTo)
            Scaffold(
                modifier = Modifier.weight(1f),
                topBar = {
                    TopAppBar(
                        title = { Text("${PortfolioContent.portfolio.bio.name} Portfolio") },
                        navigationIcon = {
                            if (currentRoute != Routes.HOME) {
                                IconButton(onClick = { navController.navigateUp() }) { Text("←") }
                            }
                        },
                        actions = {
                            IconButton(onClick = onToggleTheme) {
                                Text(if (isDark) "☀" else "☾")
                            }
                        },
                    )
                },
                bottomBar = { if (!useRail) AppBottomBar(currentRoute, navigateTo) },
            ) { innerPadding ->
                NavHost(
                    navController = navController,
                    startDestination = Routes.HOME,
                    modifier = Modifier.padding(innerPadding),
                ) {
                    composable(Routes.HOME) { HomeScreen(onViewProjects = { navigateTo(Routes.PROJECTS) }) }
                    composable(Routes.PROJECTS) { ProjectsScreen() }
                }
            }
        }
    }
}

@Composable
private fun AppBottomBar(currentRoute: String?, onNavigate: (String) -> Unit) {
    NavigationBar {
        topLevelDestinations.forEach { dest ->
            NavigationBarItem(
                selected = currentRoute == dest.route,
                onClick = { onNavigate(dest.route) },
                icon = { Text(dest.icon) },
                label = { Text(dest.label) },
            )
        }
    }
}

@Composable
private fun AppNavRail(currentRoute: String?, onNavigate: (String) -> Unit) {
    NavigationRail {
        topLevelDestinations.forEach { dest ->
            NavigationRailItem(
                selected = currentRoute == dest.route,
                onClick = { onNavigate(dest.route) },
                icon = { Text(dest.icon) },
                label = { Text(dest.label) },
            )
        }
    }
}