package uz.ttpu.portfolio.otabek.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.ttpu.portfolio.otabek.data.Skill
import uz.ttpu.portfolio.otabek.ui.components.SectionTitle

@Composable
fun SkillsSection(skills: List<Skill>, modifier: Modifier = Modifier) {
    Column(modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        SectionTitle("Skills")
        skills.groupBy { it.group }.forEach { (group, items) ->
            Column {
                Text(group.label, style = MaterialTheme.typography.titleSmall)
                Text(
                    items.joinToString(" · ") { it.name },
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}