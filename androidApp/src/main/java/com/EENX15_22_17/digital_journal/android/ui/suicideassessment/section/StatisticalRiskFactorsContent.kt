package com.EENX15_22_17.digital_journal.android.ui.suicideassessment.statisticalriskfactors

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import com.EENX15_22_17.digital_journal.android.ui.suicideassessment.protectivefactors.SuicideAssessmentModel

@Composable
fun <E : Enum<*>> StatisticalRiskFactorsContent() {
    Column{
        Row{
            SuicideAssessmentModel(
                choices = statisticalRiskFactorsValues.keys.toTypedArray(),
                onChange = { },
                currentSelected = emptySet(),
                labels = statisticalRiskFactorsValues
            )
        }
    }
}