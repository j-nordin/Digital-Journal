package com.EENX15_22_17.digital_journal.android.ui.suicideassessment.protectivefactors

import androidx.compose.runtime.Composable
import com.EENX15_22_17.digital_journal.android.ui.components_beta.CheckBoxData
import com.EENX15_22_17.digital_journal.android.ui.components_beta.DrawCheckBoxes

@Composable
fun ProtectiveFactorsItem(items : List<CheckBoxData>,
) {
    DrawCheckBoxes(items = items)
}