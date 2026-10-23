package uz.ttpu.portfolio.otabek.data

object PortfolioContent {

    val portfolio = Portfolio(
        bio = Bio(
            name = "Otabek",
            role = "Mobile & Backend Developer & DevOps",
            tagline = "I build cross-platform apps with Kotlin and Go and can deploy it",
            about = "Student at TTPU. I like Linux, DevOps and building tools that run everywhere. And someday I'll be back in 3D.",
        ),
        projects = listOf(
            Project(
                title = "Portfolio App",
                description = "This app: Kotlin Multiplatform portfolio for Android and iOS.",
                tags = listOf("Kotlin", "Compose Multiplatform"),
                repoUrl = "https://github.com/Otabek228101/Portfolio",
            ),
            Project(
                title = "Ak-47",
                description = "Modeled and textured in Blender, Marmoset and Substance",
                tags = listOf("Blender", "Marmoset", "Substance"),
                repoUrl = "https://www.artstation.com/artwork/QKG1LL",
                featured = true,
            ),
            Project(
                title = "Project Two",
                description = "Short description of the second project.(I dont have normal public projects)",
                tags = listOf("Go", "Docker"),
                repoUrl = "https://github.com/Otabek228101/project-two",
            ),
            Project(
                title = "saiga-12",
                description = "I made it myself, cool?",
                tags = listOf("Blender", "Marmoset", "Substance"),
                repoUrl = "https://www.artstation.com/artwork/w0v5gw",
                featured = true,
            ),
            Project(
                title = "Project Three",
                description = "Short description of the third project.(I dont have normal public projects)",
                tags = listOf("Linux", "Bash"),
                repoUrl = "https://github.com/Otabek228101/project-three",
            ),
        ),
        skills = listOf(
            Skill("Kotlin", SkillGroup.Languages),
            Skill("Go", SkillGroup.Languages),
            Skill("Dart", SkillGroup.Languages),
            Skill("Python", SkillGroup.Languages),
            Skill("Flutter", SkillGroup.Frameworks),
            Skill("Compose Multiplatform", SkillGroup.Frameworks),
            Skill("Gin", SkillGroup.Frameworks),
            Skill("Git", SkillGroup.Tools),
            Skill("Docker", SkillGroup.Tools),
            Skill("Linux", SkillGroup.Tools),
            Skill("Blender", SkillGroup.Tools),
            Skill("Marmoset", SkillGroup.Tools),
            Skill("Substance", SkillGroup.Tools),
            Skill("Houdini", SkillGroup.Tools),
        ),
        links = listOf(
            SocialLink("Email", "mailto:asd123asd123asd123asd321dsa@gmail.com"),
            SocialLink("GitHub", "https://github.com/Otabek228101"),
            SocialLink("Artstation", "https://www.artstation.com/den2288"),
        ),
    )
}