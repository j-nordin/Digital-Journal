package com.EENX15_22_17.digital_journal.android.screens.triage.previousCare

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.EENX15_22_17.digital_journal.android.ui.DetailPageWrapper
import com.EENX15_22_17.digital_journal.android.ui.theme.Colors

@Composable
fun TempPreviusCare(
    visitId: String,
    navBack: () -> Unit
) {
    DetailPageWrapper(
        title = "PrevCare for $visitId",
        titleColor = Colors.triagePrimary,
        onBackClicked = navBack,
    ) {

    }
}