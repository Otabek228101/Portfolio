package uz.ttpu.portfolio.otabek.ui.theme

import com.russhwolf.settings.Settings

enum class ThemeMode { System, Light, Dark }

class ThemePreferences(private val settings: Settings = Settings()) {

    fun load(): ThemeMode =
        ThemeMode.entries.firstOrNull { it.name == settings.getStringOrNull(KEY) }
            ?: ThemeMode.System

    fun save(mode: ThemeMode) = settings.putString(KEY, mode.name)

    private companion object {
        const val KEY = "theme_mode"
    }
}