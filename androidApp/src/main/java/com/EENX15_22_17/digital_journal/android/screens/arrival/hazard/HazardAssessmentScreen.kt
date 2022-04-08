package com.EENX15_22_17.digital_journal.android.screens.arrival.hazard

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.EENX15_22_17.digital_journal.android.ui.DetailPageWrapper
import com.EENX15_22_17.digital_journal.android.ui.theme.Colors

@Composable
fun TempHazardAssessment(
    visitId: String,
    navBack: () -> Unit
) {
    DetailPageWrapper(
        title = "HazardAssessment for $visitId",
        titleColor = Colors.arrivalPrimary,
        onBackClicked = navBack,
    ) {

    }
}