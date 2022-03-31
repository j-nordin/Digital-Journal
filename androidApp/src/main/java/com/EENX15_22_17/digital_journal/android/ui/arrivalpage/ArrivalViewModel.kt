package com.EENX15_22_17.digital_journal.android.ui.arrivalpage

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.compose.runtime.setValue
import androidx.core.os.bundleOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import java.util.*

class ArrivalViewModel : ViewModel() {
    var arrivalStates by mutableStateOf(
        ArrivalDataClass(
            date = Date(),
            timestamp = "",
            ess = "",
            secrecy = YesAndNoAndNoAnswer.NO_ANSWER,
            reservation = "",
            confirmedIdentity = YesNo.UNKOWN,
            samsa = YesNo.UNKOWN,
            relativeName = "",
            relativePhoneNumber = "",
            children = mutableListOf(),
            concernReport = YesNo.UNKOWN,
            arrivalMethod = ArrivalMethod.UNKNOWN,
            law = Law.UNKNOWN
        )
    )
        private set

    fun getTimestamp(): String {
        val dateToFormat = this.arrivalStates.date.toString()
        return dateToFormat.subSequence(0, 10).toString()
    }
}
