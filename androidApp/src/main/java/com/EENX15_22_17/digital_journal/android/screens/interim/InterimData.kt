package com.EENX15_22_17.digital_journal.android.screens.interim

import com.EENX15_22_17.digital_journal.android.dataModel.YesAndNoAndNoAnswer

data class InterimData(
    var patientDecision: Set<PatientDecision>,
    var remittedType: String,
    var preliminaryDepartment: String,
    var preliminaryAssessment: String,
    var weapons: YesAndNoAndNoAnswer,
    var drivingLicence: YesAndNoAndNoAnswer,
    var laws: Set<InterimLaw>,
    var transportation: Set<Transport>,
    var observationLevel: String,
    var finalDepartment: String,
    var ssk: String,
    var time: String,
    var admissionDecision: String
)


enum class PatientDecision {
    PATIENT_SENT_HOME,
    PATIENT_REMITTED,
    PATIENT_HOSPITALIZED
}

enum class InterimLaw {
    HSL,
    LPT,
    LVM,
    LRV
}

enum class Transport {
    TAXI_OR_PRIVATE_TRANSPORT,
    PATIENT_TRANSPORTATION,
    POLICE,
    AMBULANCE,
    CORRECTIONAL_TREATMENT
}