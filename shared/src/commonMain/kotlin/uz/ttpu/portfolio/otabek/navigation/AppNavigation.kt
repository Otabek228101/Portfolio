package uz.ttpu.portfolio.otabek.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
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
import uz.ttpu.portfolio.otabek.ui.screens.HomeScreen
import uz.ttpu.portfolio.otabek.ui.screens.ProjectsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    fun navigateTo(route: String) {
        navController.navigate(route) {
            popUpTo(Routes.HOME) { saveState = true }
            launchSingleTop = true
            restoreState = true
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("${PortfolioContent.portfolio.bio.name} Portfolio") },
                navigationIcon = {
                    if (currentRoute != Routes.HOME) {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Text("←")
                        }
                    }
                },
            )
        },
        bottomBar = {
            NavigationBar {
                topLevelDestinations.forEach { dest ->
                    NavigationBarItem(
                        selected = currentRoute == dest.route,
                        onClick = { navigateTo(dest.route) },
                        icon = { Text(dest.icon) },
                        label = { Text(dest.label) },
                    )
                }
            }
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Routes.HOME,
            modifier = Modifier.padding(innerPadding),
        ) {
            composable(Routes.HOME) {
                HomeScreen(onViewProjects = { navigateTo(Routes.PROJECTS) })
            }
            composable(Routes.PROJECTS) {
                ProjectsScreen()
            }
        }
    }
}