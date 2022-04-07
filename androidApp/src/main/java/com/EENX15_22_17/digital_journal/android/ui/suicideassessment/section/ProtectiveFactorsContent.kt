package com.EENX15_22_17.digital_journal.android.ui.suicideassessment.section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import com.EENX15_22_17.digital_journal.android.ui.suicideassessment.protectivefactors.ProtectiveFactors
import com.EENX15_22_17.digital_journal.android.ui.suicideassessment.protectivefactors.protectiveFactorsValues
import com.EENX15_22_17.digital_journal.android.ui.triage.history.SomaticHealth

@Composable
fun <E : Enum<*>> ProtectiveFactorsContent (

) {

    Column{
        Row{
            ProtectiveFactors(
                    choices = protectiveFactorsValues.keys.toTypedArray(),
                    onChange = { },
                    currentSelected = emptySet(),
                    labels = protectiveFactorsValues
                )
        }

    }
}