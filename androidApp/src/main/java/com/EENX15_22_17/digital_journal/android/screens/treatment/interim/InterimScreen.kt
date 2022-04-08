package com.EENX15_22_17.digital_journal.android.screens.treatment.interim

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.EENX15_22_17.digital_journal.android.ui.DetailPageWrapper
import com.EENX15_22_17.digital_journal.android.ui.theme.Colors

@Composable
fun TempInterim(
    visitId: String,
    navBack: () -> Unit
) {
    DetailPageWrapper(
        title = "Interim for $visitId",
        titleColor = Colors.treatmentPrimary,
        onBackClicked = navBack,
    ) {

    }
}