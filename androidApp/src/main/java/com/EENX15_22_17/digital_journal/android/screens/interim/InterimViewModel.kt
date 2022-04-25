package com.EENX15_22_17.digital_journal.android.screens.interim

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.EENX15_22_17.digital_journal.android.dataModel.YesAndNoAndNoAnswer

class InterimViewModel: ViewModel() {
    var interimStates: InterimData by mutableStateOf(
        InterimData(
            patientDecision = setOf<PatientDecision>(),
            remittedType = "",
            preliminaryDepartment = "",
            preliminaryAssessment = "",
            weapons = YesAndNoAndNoAnswer.UNKOWN,
            drivingLicence = YesAndNoAndNoAnswer.UNKOWN,
            laws = setOf<InterimLaw>(),
            transportation = setOf<Transport>(),
            observationLevel = "",
            finalDepartment = "",
            ssk = "",
            time = "",
            admissionDecision = ""
        )
    )
}