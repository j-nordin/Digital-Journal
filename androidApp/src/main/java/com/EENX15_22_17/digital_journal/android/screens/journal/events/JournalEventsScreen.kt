package com.EENX15_22_17.digital_journal.android.screens.journal.events

import androidx.compose.runtime.Composable
import com.EENX15_22_17.digital_journal.android.ui.DetailPageWrapper
import com.EENX15_22_17.digital_journal.android.ui.theme.Colors
import se.predicare.journal.data.Labels.labels
import se.predicare.journal.screens.JournalScreen
import se.predicare.journal.screens.JournalSection

@Composable
fun JournalEventsScreen(
    journalId: String,
    onBackClicked: () -> Unit,
    onMenuClicked: () -> Unit
) {
    DetailPageWrapper(
        titleColor = Colors.journalSectionColors[JournalSection.EVENTS]!!,
        title = JournalScreen.labels[JournalScreen.EVENTS]!!,
        onBackClicked = onBackClicked,
        onMenuClicked = onMenuClicked
    ) {

    }
}