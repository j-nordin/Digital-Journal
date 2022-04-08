package com.EENX15_22_17.digital_journal.android.ui.suicideassessment.section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import com.EENX15_22_17.digital_journal.android.ui.suicideassessment.protectivefactors.SuicideAssessmentModel
import com.EENX15_22_17.digital_journal.android.ui.suicideassessment.protectivefactors.protectiveFactorsValues

@Composable
fun <E : Enum<*>> ProtectiveFactorsContent () {
    Column{
        Row{
            SuicideAssessmentModel(
                    choices = protectiveFactorsValues.keys.toTypedArray(),
                    onChange = { },
                    currentSelected = emptySet(),
                    labels = protectiveFactorsValues
                )
        }
    }
}