package com.EENX15_22_17.digital_journal.android.screens.triage.suicideassessment.protectivefactors


enum class ProtectiveFactorsData {
    AVAILABLE_PERSONNEL_RESOURCE,
    AVAILABLE_NETWORK_RESOURCE,
    DIFFICULT_TO_ASSES,
    NO,

}

val protectiveFactorsLabels = mapOf<ProtectiveFactorsData, String>(
    ProtectiveFactorsData.AVAILABLE_PERSONNEL_RESOURCE to "Personell resurs, t. ex. god samtalskontakt",
    ProtectiveFactorsData.AVAILABLE_NETWORK_RESOURCE to "Nätverkets resurs, t. ex. anhöriga, vänner",
    ProtectiveFactorsData.DIFFICULT_TO_ASSES to "Svårbedömt",
    ProtectiveFactorsData.NO to "Nej",
)
