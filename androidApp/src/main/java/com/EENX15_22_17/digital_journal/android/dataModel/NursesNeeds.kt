package com.EENX15_22_17.digital_journal.android.dataModel

enum class NursesNeeds {
    GENERALHYGIENE,
    TOILET,
    LIQUIDINTAKE,
    STANDANDWALK,
    UNKOWN
}

val nursesNeeds = mapOf<NursesNeeds, String>(
    NursesNeeds.GENERALHYGIENE to "Allmänhygien",
    NursesNeeds.TOILET to "Toa",
    NursesNeeds.LIQUIDINTAKE to "Vätske intag",
    NursesNeeds.STANDANDWALK to "Stå+Gå",
)
