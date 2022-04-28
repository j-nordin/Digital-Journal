package com.EENX15_22_17.digital_journal.android.screens.journal.arrival.patientInfo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.EENX15_22_17.digital_journal.android.dataModel.YesAndNoAndNoAnswer
import com.EENX15_22_17.digital_journal.android.dataModel.YesNo
import java.util.*

class PatientInfoViewModel : ViewModel() {
    var arrivalStates by mutableStateOf(
        PatientInfoDataClass(
            date = Date(),
            timestamp = "",
            ess = "",
            secrecy = YesAndNoAndNoAnswer.NO_ANSWER,
            reservation = "",
            confirmedIdentity = YesNo.UNKOWN,
            samsa = YesNo.UNKOWN,
            relativeName = "",
            relativePhoneNumber = "",
            children = mutableListOf<String>(),
            concernReport = YesNo.UNKOWN,
            lockNumber = "",
            signature = "",
        )
    )
        private set

    fun getTimestamp(): String {
        val dateToFormat = this.arrivalStates.date.toString()
        return dateToFormat.subSequence(0, 10).toString()
    }
}
