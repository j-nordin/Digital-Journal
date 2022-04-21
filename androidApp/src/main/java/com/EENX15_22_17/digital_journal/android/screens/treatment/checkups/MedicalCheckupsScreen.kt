package com.EENX15_22_17.digital_journal.android.screens.treatment.checkups

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.EENX15_22_17.digital_journal.android.ui.DetailPageWrapper
import com.EENX15_22_17.digital_journal.android.ui.theme.Colors

@Composable
fun TempMedicalCheckup(
    visitId: String,
    navBack: () -> Unit
) {
    DetailPageWrapper(
        title = "Controls for $visitId",
        titleColor = Colors.treatmentPrimary,
        onBackClicked = navBack,
    ) {

    }
}