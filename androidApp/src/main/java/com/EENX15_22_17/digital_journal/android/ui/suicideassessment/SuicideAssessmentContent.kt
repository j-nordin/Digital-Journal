package com.EENX15_22_17.digital_journal.android.ui.suicideassessment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import com.EENX15_22_17.digital_journal.android.ui.suicideassessment.protectivefactors.SuicideAssessmentModel
import com.EENX15_22_17.digital_journal.android.ui.suicideassessment.protectivefactors.protectiveFactorsValues
import com.EENX15_22_17.digital_journal.android.ui.suicideassessment.statisticalriskfactors.statisticalRiskFactorsValues

//TODO: Complete onChange and currentSelected parameters after implementing Suicide Assessment Modelview

@Composable
fun <E : Enum<*>> SuicideStepsContent() {
    Column {
        Row {
            SuicideAssessmentModel(
                choices = suicideStepsValues.keys.toTypedArray(),
                onChange = { },
                currentSelected = emptySet(),
                labels = suicideStepsValues
            )
        }
    }
}


@Composable
fun <E : Enum<*>> StatisticalRiskFactorsContent() {
    Column {
        Row {
            SuicideAssessmentModel(
                choices = statisticalRiskFactorsValues.keys.toTypedArray(),
                onChange = { },
                currentSelected = emptySet(),
                labels = statisticalRiskFactorsValues
            )
        }
    }
}

@Composable
fun <E : Enum<*>> ProtectiveFactorsContent() {
    Column {
        Row {
            SuicideAssessmentModel(
                choices = protectiveFactorsValues.keys.toTypedArray(),
                onChange = { },
                currentSelected = emptySet(),
                labels = protectiveFactorsValues
            )
        }
    }
}