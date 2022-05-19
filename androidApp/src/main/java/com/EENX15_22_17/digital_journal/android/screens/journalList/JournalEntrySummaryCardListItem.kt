package com.EENX15_22_17.digital_journal.android.screens.journalList


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Timer
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.ui.components.TitledSectionWithRettsColor
import com.EENX15_22_17.digital_journal.android.ui.components.UnclickableChip
import com.EENX15_22_17.digital_journal.android.ui.theme.colorTextGray
import se.predicare.journal.data.JournalEntryDto

@Composable
fun JournalList(
    modifier: Modifier = Modifier,
    @PreviewParameter(SampleCurrentPatientsProvider::class)
    journals: List<JournalEntryDto>,
    onNavigateToJournal: (journalId: String) -> Unit = {},
    onNavigateToPatient: (patientId: String) -> Unit = {}
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .verticalScroll(scrollState)
            .height(400.dp)
    ) {
        for (journal in journals) {
            JournalListCard(
                journal = journal,
                onNavigateToPatient = { onNavigateToPatient("<patientId goes here>") },
                onNavigateToJournal = { onNavigateToJournal(it) }
            )

        }
    }
}

@Composable
fun JournalListCard(
    journal: JournalEntryDto,
    onNavigateToPatient: () -> Unit,
    onNavigateToJournal: (journalId: String) -> Unit
    ) {
    TitledSectionWithRettsColor(
        modifier = Modifier.clickable { journal._id?.let { onNavigateToJournal(it) } },
        title = journal.patientInfo.patientData?.name ?: "Patient",
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "BVC-poäng: " )
                Box(modifier = Modifier.border(1.dp, Color.Red, RoundedCornerShape(5.dp))) {
                    Text(
                        modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp),
                        text = journal.hazardAssessment.hazardAssessmentStatements.size.toString()
                    )
                }
                Spacer(Modifier.size(30.dp))
                Text(text = "Vidtagna åtgärder: ")
                /* TODO: Fetch actions taken from; journal.hazardAssessment.hazardAssessmentActionsTaken */
                UnclickableChip(text = "Väktare")
                UnclickableChip(text = "Ambulanssida")
            }
        }
    }
}