package uz.ttpu.portfolio.otabek.ui.components

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class WidthClass { Compact, Medium, Expanded }

val LocalWidthClass = staticCompositionLocalOf { WidthClass.Compact }

fun widthClassOf(width: Dp): WidthClass = when {
    width < 600.dp -> WidthClass.Compact
    width < 840.dp -> WidthClass.Medium
    else -> WidthClass.Expanded
}

fun WidthClass.gridColumns(): Int = when (this) {
    WidthClass.Compact -> 1
    WidthClass.Medium -> 2
    WidthClass.Expanded -> 3
}

@Composable
fun ProvideWidthClass(content: @Composable () -> Unit) {
    BoxWithConstraints {
        CompositionLocalProvider(LocalWidthClass provides widthClassOf(maxWidth)) {
            content()
        }
    }
}