package uz.ttpu.portfolio.otabek.data

data class Bio(
    val name: String,
    val role: String,
    val tagline: String,
    val about: String,
)

data class Project(
    val title: String,
    val description: String,
    val tags: List<String>,
    val repoUrl: String,
    val demoUrl: String? = null,
    val imageName: String? = null,
)

enum class SkillGroup(val label: String) {
    Languages("Languages"),
    Frameworks("Frameworks"),
    Tools("Tools"),
}

data class Skill(
    val name: String,
    val group: SkillGroup,
)

data class SocialLink(
    val label: String,
    val url: String,
)

data class Portfolio(
    val bio: Bio,
    val projects: List<Project>,
    val skills: List<Skill>,
    val links: List<SocialLink>,
)