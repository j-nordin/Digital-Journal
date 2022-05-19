package com.EENX15_22_17.digital_journal.android.screens.journalList


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.ui.components.TitledSectionWithRettsColor
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
        modifier = Modifier
            .verticalScroll(scrollState)
            .height(400.dp)
    ) {
        for (journal in journals) {
            JournalListCard(
                /*modifier = Modifier.clickable { journal._id?.let { onNavigateToJournal(it) } },
                title = journal.patientInfo.patientData?.name ?: "",*/
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

    }
}