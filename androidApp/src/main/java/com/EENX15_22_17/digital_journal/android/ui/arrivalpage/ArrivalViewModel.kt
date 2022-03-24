package com.EENX15_22_17.digital_journal.android.ui.arrivalpage

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.util.*

class ArrivalViewModel() : ViewModel() {

    var arrivalStates by mutableStateOf<ArrivalDataClass>(
        ArrivalDataClass(
            date = Date(),
            timestamp = "",
            ess = 0,
            secrecy = YesAndNoAndNoAnswer.NO_ANSWER,
            reservation = "",
            confirmedIdentity = false,
            samsa = false,
            relativeName = "",
            relativePhoneNumber = "",
            children = arrayOf(0),
            concernReport = false,
            arrivalMethod = ArrivalMethod.UNKNOWN,
            law = Law.UNKNOWN
        )
    )
        private set

    fun getTimeStamp(): String {
        return this.arrivalStates.date.toString()
    }
}
