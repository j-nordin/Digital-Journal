package com.EENX15_22_17.digital_journal.android.ui.hazardassesment

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import java.util.*

class HazardViewModel : ViewModel() {
    var hazardStates by mutableStateOf(
        HazardDataClass(
            initialAssessment = setOf<DangerType>(),
            specifiedBehavior = setOf<DangerBehaviors>(),
            takenActions = ""
        )
    )

   /* fun updateBVC(spec: Set<DangerBehaviors>) {
        this.hazardStates.nrOfBVC = spec.size
    }*/
}