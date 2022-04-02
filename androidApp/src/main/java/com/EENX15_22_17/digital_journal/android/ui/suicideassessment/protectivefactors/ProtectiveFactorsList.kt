package com.EENX15_22_17.digital_journal.android.ui.suicideassessment.protectivefactors

import androidx.compose.runtime.Composable
import com.EENX15_22_17.digital_journal.android.ui.components_beta.CheckBoxData


fun ProtectiveFactorsList(): List<CheckBoxData> {
    return listOf(
        CheckBoxData(
            checkBoxName = "Personell resurs, t. ex. god samtalskontakt",
            checkBoxValue = false,
            checkBoxId = "personnel_resource"
        ),
        CheckBoxData(
            checkBoxName = "Nätverkets resurs, t. ex. anhöriga, vänner",
            checkBoxValue = false,
            checkBoxId = "network_resource"
        ),
        CheckBoxData(
            checkBoxName = "Svårbedömt",
            checkBoxValue = false,
            checkBoxId = "difficult_to_assess"
        ),
        CheckBoxData(
            checkBoxName = "Nej",
            checkBoxValue = false,
            checkBoxId = "no"
        )
    )
}