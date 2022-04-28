package com.EENX15_22_17.digital_journal.android.screens.journal.arrival.hazardAssessment

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HazardViewModel : ViewModel() {
    var hazardStates by mutableStateOf(
        HazardDataClass(
            initialAssessment = setOf<DangerType>(),
            specifiedBehavior = setOf<DangerBehaviors>(),
            takenActions = "",
            law = setOf<Law>(),
            arrivalMethod = setOf<ArrivalMethod>()
        )
    )
}