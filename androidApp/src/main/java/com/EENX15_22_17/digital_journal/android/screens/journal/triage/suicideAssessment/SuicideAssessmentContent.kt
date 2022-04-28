package com.EENX15_22_17.digital_journal.android.screens.journal.triage.suicideAssessment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import com.EENX15_22_17.digital_journal.android.screens.journal.triage.suicideAssessment.protectivefactors.SuicideAssessmentModel
import com.EENX15_22_17.digital_journal.android.screens.journal.triage.suicideAssessment.protectivefactors.protectiveFactorsLabels
import com.EENX15_22_17.digital_journal.android.screens.journal.triage.suicideAssessment.statisticalriskfactors.statisticalRiskFactorsLabels

//TODO: Complete onChange and currentSelected parameters after implementing Suicide Assessment Modelview

@Composable
fun <E : Enum<*>> SuicideStepsContent() {
    Column {
        Row {
            SuicideAssessmentModel(
                choices = suicideStepsLabels.keys.toTypedArray(),
                onChange = { },
                currentSelected = emptySet(),
                labels = suicideStepsLabels
            )
        }
    }
}


@Composable
fun <E : Enum<*>> StatisticalRiskFactorsContent() {
    Column {
        Row {
            SuicideAssessmentModel(
                choices = statisticalRiskFactorsLabels.keys.toTypedArray(),
                onChange = { },
                currentSelected = emptySet(),
                labels = statisticalRiskFactorsLabels
            )
        }
    }
}

@Composable
fun <E : Enum<*>> ProtectiveFactorsContent() {
    Column {
        Row {
            SuicideAssessmentModel(
                choices = protectiveFactorsLabels.keys.toTypedArray(),
                onChange = { },
                currentSelected = emptySet(),
                labels = protectiveFactorsLabels
            )
        }
    }
}