package com.EENX15_22_17.digital_journal.android.ui.suicideassessment.protectivefactors

import androidx.compose.runtime.Composable
import com.EENX15_22_17.digital_journal.android.ui.components_beta.CheckBoxData
import com.EENX15_22_17.digital_journal.android.ui.suicideassessment.statisticalriskfactors.StatisticalRiskFactorsItem

@Composable
fun ProtectiveFactorsList()  {
    return ProtectiveFactorsItem(items = listOf(
        CheckBoxData(
            checkBoxName = "Personell resurs, t. ex. god samtalskontakt",
            checkBoxValue = false,
        ),
        CheckBoxData(
            checkBoxName = "Nätverkets resurs, t. ex. anhöriga, vänner",
            checkBoxValue = false,
        ),
        CheckBoxData(
            checkBoxName = "Svårbedömt",
            checkBoxValue = false,
        ),
        CheckBoxData(
            checkBoxName = "Nej",
            checkBoxValue = false,
        )
    ))
}