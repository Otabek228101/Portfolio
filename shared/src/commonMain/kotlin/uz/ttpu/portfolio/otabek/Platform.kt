package uz.ttpu.portfolio.otabek

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform