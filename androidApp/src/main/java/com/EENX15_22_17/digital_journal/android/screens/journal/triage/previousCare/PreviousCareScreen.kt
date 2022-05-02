package com.EENX15_22_17.digital_journal.android.screens.journal.triage.previousCare

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.R
import com.EENX15_22_17.digital_journal.android.ui.DetailPageWrapper
import com.EENX15_22_17.digital_journal.android.ui.components.TitledSection
import com.EENX15_22_17.digital_journal.android.ui.theme.Colors
import se.predicare.journal.screens.PreviousCareDto

@Composable
fun PreviousCareScreen(
    journalId: String,
    onBackClicked: () -> Unit,
    onMenuClicked: () -> Unit
) {
    DetailPageWrapper(
        title = stringResource(id = R.string.previousCare),
        titleColor = Colors.triagePrimary,
        onBackClicked = onBackClicked,
        onMenuClicked = onMenuClicked
    ) {
        Column(modifier = Modifier.padding(top=20.dp)) {
            TitledSection(title = stringResource(id = R.string.previousHealtCare)) {
                PreviousHealthCare(item = PreviousCareDto())
            }
            TitledSection(title = stringResource(id = R.string.previousJournalInPsychiatry)) {
                previousJournalInPsychiatry(item = PreviousCareDto())
            }
        }
    }
}