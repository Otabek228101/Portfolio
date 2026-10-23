package uz.ttpu.portfolio.otabek.navigation

object Routes {
    const val HOME = "home"
    const val PROJECTS = "projects"
}

data class TopLevelDestination(
    val route: String,
    val label: String,
    val icon: String,
)

val topLevelDestinations = listOf(
    TopLevelDestination(Routes.HOME, "Home", "⌂"),
    TopLevelDestination(Routes.PROJECTS, "Projects", "☰"),
)