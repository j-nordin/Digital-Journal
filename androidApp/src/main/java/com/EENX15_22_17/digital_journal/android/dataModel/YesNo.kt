package com.EENX15_22_17.digital_journal.android.dataModel

enum class YesNo {
    YES,
    NO,
    UNKOWN
}

val yesNoLabels = mapOf<YesNo, String>(
    YesNo.YES to "Ja",
    YesNo.NO to "Nej"
)