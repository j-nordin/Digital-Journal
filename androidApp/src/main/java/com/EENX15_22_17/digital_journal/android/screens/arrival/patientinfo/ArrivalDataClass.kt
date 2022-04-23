package com.EENX15_22_17.digital_journal.android.screens.arrival.patientinfo

import com.EENX15_22_17.digital_journal.android.dataModel.YesNo
import java.util.*

data class ArrivalDataClass(
    val date: Date,
    var timestamp: String,
    var ess: String,
    var secrecy: YesAndNoAndNoAnswer,
    var reservation: String,
    var confirmedIdentity: YesNo,
    var samsa: YesNo,
    var relativeName: String,
    var relativePhoneNumber: String,
    var children: MutableList<String>,
    var concernReport: YesNo,
    var lockNumber: String,
    var signature: String
)

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

