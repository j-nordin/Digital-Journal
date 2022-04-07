package com.EENX15_22_17.digital_journal.android.ui.arrivalpage

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
    var children: MutableList<Int>,
    var concernReport: YesNo,
    var arrivalMethod: Set<ArrivalMethod>,
    var law: Set<Law>
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

enum class ArrivalMethod {
    OWN_INITIATIVE,
    RELATIVE,
    REMISS,
    MEDICINE,
    ALONE,
    AMBULANCE,
    POLICE,
    OTHER,
    UNKNOWN
}

val arrivalMethods = mapOf<ArrivalMethod, String>(
    ArrivalMethod.OWN_INITIATIVE to "Eget intiativ",
    ArrivalMethod.RELATIVE to "Med Anhörig",
    ArrivalMethod.REMISS to "Med Remiss",
    ArrivalMethod.MEDICINE to "Från Medicininstag",
    ArrivalMethod.ALONE to "Ensam",
    ArrivalMethod.AMBULANCE to "Med Ambulans",
    ArrivalMethod.POLICE to "Med Polis",
    ArrivalMethod.OTHER to "Annat"
)


enum class Law {
    HSL,
    LPT,
    FORTYSEVEN,
    VI,
    LRV,
    LVM,
    UNKNOWN
}

val laws = mapOf<Law, String>(
    Law.HSL to "HSL",
    Law.LPT to "LPT",
    Law.FORTYSEVEN to "$ 47",
    Law.VI to "VI",
    Law.LRV to "LRV",
    Law.LVM to "LVM",
)
