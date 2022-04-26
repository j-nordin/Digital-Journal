package com.EENX15_22_17.digital_journal.android.dataModel

import se.predicare.journal.data.YesNoQuestion

enum class YesAndNoAndNoAnswer {
    YES,
    NO,
    NO_ANSWER,
    UNKOWN;
}

// TODO: Match Predicare api
val yesNoNoAnswerLabels = mapOf<YesAndNoAndNoAnswer, String>(
    YesAndNoAndNoAnswer.YES to "Ja",
    YesAndNoAndNoAnswer.NO to "Nej",
    YesAndNoAndNoAnswer.NO_ANSWER to "Inget svar"
)


// TODO: Match Predicare api
val yesNoQuestionLabels = mapOf<YesNoQuestion, String>(
    YesNoQuestion.NO to "Nej",
    YesNoQuestion.YES to "Yes",
    YesNoQuestion.UNANSWERED to "Inget svar"
)