package com.EENX15_22_17.digital_journal.android.ui.suicideassessment.protectivefactors

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.EENX15_22_17.digital_journal.android.ui.components_beta.CheckBoxData
import com.EENX15_22_17.digital_journal.android.ui.suicideassessment.DrawCheckBoxes

@Composable
fun ProtectiveFactorsItem(items : List<CheckBoxData>,
) {
    DrawCheckBoxes(items = items)
}