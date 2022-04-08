package com.EENX15_22_17.digital_journal.android.ui.suicideassessment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.EENX15_22_17.digital_journal.android.ui.components_beta.CheckBoxData
import com.EENX15_22_17.digital_journal.android.ui.components_beta.CheckboxSection
import com.EENX15_22_17.digital_journal.android.ui.suicideassessment.protectivefactors.SuicideAssessmentModel
import com.EENX15_22_17.digital_journal.android.ui.suicideassessment.statisticalriskfactors.statisticalRiskFactorsValues

@Composable
fun <E : Enum<*>> SuicideStepsContent (){
    Column{
        Row{
            SuicideAssessmentModel(
                choices = suicideStepsValues.keys.toTypedArray(),
                onChange = { },
                currentSelected = emptySet(),
                labels = suicideStepsValues
            )
        }
    }
}
