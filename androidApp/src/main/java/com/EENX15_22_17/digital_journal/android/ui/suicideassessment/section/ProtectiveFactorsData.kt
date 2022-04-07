package com.EENX15_22_17.digital_journal.android.ui.suicideassessment.protectivefactors


enum class ProtectiveFactorsData {
    PERSONALRESOURCE,
    NETWORKRESOURCE,
    DIFFICULTOASSESS,
    NO,

}

val protectiveFactorsValues = mapOf<ProtectiveFactorsData, String>(
    ProtectiveFactorsData.PERSONALRESOURCE to "Personell resurs, t. ex. god samtalskontakt",
    ProtectiveFactorsData.NETWORKRESOURCE to "Nätverkets resurs, t. ex. anhöriga, vänner",
    ProtectiveFactorsData.DIFFICULTOASSESS to "Svårbedömt",
    ProtectiveFactorsData.NO to "Nej",
)
