package com.EENX15_22_17.digital_journal.android.dataModel

enum class YesAndNoAndNoAnswer {
    YES,
    NO,
    NO_ANSWER,
    UNKOWN;
}

val yesNoNoAnswerLabels = mapOf<YesAndNoAndNoAnswer, String>(
    YesAndNoAndNoAnswer.YES to "Ja",
    YesAndNoAndNoAnswer.NO to "Nej",
    YesAndNoAndNoAnswer.NO_ANSWER to "Inget svar"
)