package com.EENX15_22_17.digital_journal.android.ui.hazardassesment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.EENX15_22_17.digital_journal.android.ui.hazardassesment.*

@Composable
fun HazardAss(
    navBack: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.Center
    ) {
        ActionTakenTextField(setActionTaken = {}, actionTaken = "")
    }

}