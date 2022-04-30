package com.EENX15_22_17.digital_journal.android.screens.journal.triage.previousCare

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.EENX15_22_17.digital_journal.android.R
import com.EENX15_22_17.digital_journal.android.ui.DetailPageWrapper
import com.EENX15_22_17.digital_journal.android.ui.theme.Colors

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

    }
}