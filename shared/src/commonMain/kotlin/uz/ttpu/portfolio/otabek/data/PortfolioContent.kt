package uz.ttpu.portfolio.otabek.data

object PortfolioContent {

    val portfolio = Portfolio(
        bio = Bio(
            name = "Otabek",
            role = "Mobile & Backend Developer",
            tagline = "I build cross-platform apps with Kotlin and Go.",
            about = "Student at TTPU. I like Linux, DevOps and building tools that run everywhere.",
        ),
        projects = listOf(
            Project(
                title = "Portfolio App",
                description = "This app: Kotlin Multiplatform portfolio for Android and iOS.",
                tags = listOf("Kotlin", "Compose Multiplatform"),
                repoUrl = "https://github.com/Otabek228101/Portfolio",
            ),
            Project(
                title = "Project Two",
                description = "Short description of the second project.",
                tags = listOf("Go", "Docker"),
                repoUrl = "https://github.com/Otabek228101/project-two",
            ),
            Project(
                title = "Project Three",
                description = "Short description of the third project.",
                tags = listOf("Linux", "Bash"),
                repoUrl = "https://github.com/Otabek228101/project-three",
                demoUrl = "https://example.com",
            ),
        ),
        skills = listOf(
            Skill("Kotlin", SkillGroup.Languages),
            Skill("Go", SkillGroup.Languages),
            Skill("Compose Multiplatform", SkillGroup.Frameworks),
            Skill("Gin", SkillGroup.Frameworks),
            Skill("Git", SkillGroup.Tools),
            Skill("Docker", SkillGroup.Tools),
            Skill("Linux", SkillGroup.Tools),
        ),
        links = listOf(
            SocialLink("Email", "mailto:you@example.com"),
            SocialLink("GitHub", "https://github.com/Otabek228101"),
            SocialLink("LinkedIn", "https://www.linkedin.com/in/your-profile"),
        ),
    )
}