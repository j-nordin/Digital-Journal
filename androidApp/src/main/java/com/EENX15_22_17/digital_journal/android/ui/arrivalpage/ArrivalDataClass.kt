package com.EENX15_22_17.digital_journal.android.ui.arrivalpage

import java.util.*

data class ArrivalDataClass(
    val date: Date,
    var timestamp: String,
    var ess: String,
    var secrecy: YesAndNoAndNoAnswer,
    var reservation: String,
    var confirmedIdentity: Boolean,
    var samsa: Boolean,
    var relativeName: String,
    var relativePhoneNumber: String,
    val children: Array<Int>,
    val concernReport: Boolean,
    val arrivalMethod: ArrivalMethod,
    val law: Law
)

enum class YesAndNoAndNoAnswer {
    YES,
    NO,
    NO_ANSWER,
    UNKOWN;
}

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

enum class Law {
    HSL,
    LPT,
    FORTYSEVEN,
    VI,
    LRV,
    LVM,
    UNKNOWN
}
