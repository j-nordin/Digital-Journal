package com.EENX15_22_17.digital_journal.android.screens.treatment.ordination

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.EENX15_22_17.digital_journal.android.ui.DetailPageWrapper
import com.EENX15_22_17.digital_journal.android.ui.theme.Colors

@Preview
@Composable
fun OrdinationScreen(
    onBackClicked: () -> Unit = {},
    onMenuClicked: () -> Unit = {},
) {
    DetailPageWrapper(
        title = "Åtgärd / Ordination", // TODO: Use `JournalScreen.ACTIONS_AND_ORDINATIONS.title` when libs are available,
        titleColor = Colors.treatmentPrimary,
        onBackClicked = onBackClicked,
        onMenuClicked = onMenuClicked
    ) {

    }
}
