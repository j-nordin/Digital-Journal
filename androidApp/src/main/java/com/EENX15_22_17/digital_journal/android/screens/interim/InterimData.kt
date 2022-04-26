package com.EENX15_22_17.digital_journal.android.screens.interim

import com.EENX15_22_17.digital_journal.android.dataModel.YesAndNoAndNoAnswer
import se.predicare.journal.data.ArrivalLaws
import se.predicare.journal.screens.InterimJournalDto

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

val patientDecision = mapOf<InterimJournalDto.PatientAction, String>(
    InterimJournalDto.PatientAction.PATIENT_SENT_HOME to "Patienten går hem",
    InterimJournalDto.PatientAction.PATIENT_REMITTED to "Patienten remitterad",
    InterimJournalDto.PatientAction.PATIENT_HOSPITALIZED to "Inläggning avdelning"
)

val patientDecisionTextfields = mapOf<InterimJournalDto.PatientAction, Boolean>(
    InterimJournalDto.PatientAction.PATIENT_SENT_HOME to false,
    InterimJournalDto.PatientAction.PATIENT_REMITTED to true,
    InterimJournalDto.PatientAction.PATIENT_HOSPITALIZED to true
)

val patientDecisionTitles = mapOf<InterimJournalDto.PatientAction, String>(
    InterimJournalDto.PatientAction.PATIENT_REMITTED to "Till vård",
    InterimJournalDto.PatientAction.PATIENT_HOSPITALIZED to "Till avdelning"
)

val arrivalLaws = mapOf<ArrivalLaws, String>(
    ArrivalLaws.HSL to "HSL",
    ArrivalLaws.LPT to "LPT",
    ArrivalLaws.PARAGRAPH_47 to "$47",
    ArrivalLaws.VI to "VI",
    ArrivalLaws.LRV to "LRV",
    ArrivalLaws.LVM to "LVM",
)

val transportationWaysLabel = mapOf<InterimJournalDto.WayOfTransport, String>(
    InterimJournalDto.WayOfTransport.TAXI_OR_PRIVATE_TRANSPORT to "Taxi/Privat",
    InterimJournalDto.WayOfTransport.PATIENT_TRANSPORTATION to "Sjuktransport",
    InterimJournalDto.WayOfTransport.CORRECTIONAL_TREATMENT to "Häktespersonal/kriminalvården",
    InterimJournalDto.WayOfTransport.POLICE to "Polis",
    InterimJournalDto.WayOfTransport.AMBULANCE to "Ambulanstransport"
)

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