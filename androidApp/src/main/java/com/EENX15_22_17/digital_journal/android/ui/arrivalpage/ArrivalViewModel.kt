package com.EENX15_22_17.digital_journal.android.ui.arrivalpage

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.util.*

class ArrivalViewModel : ViewModel() {

    var arrivalStates by mutableStateOf(
        ArrivalDataClass(
            date = Date(),
            timestamp = "",
            ess = "",
            secrecy = YesAndNoAndNoAnswer.NO,
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

    fun getTimestamp(): String {
        val dateToFormat = this.arrivalStates.date.toString()
        return dateToFormat.subSequence(0, 10).toString()
    }


    //TODO: Fråga Rickard. Dessa metoder (om dem nu är bra) ska användas mer än bara i arrival.
    // Kanske skulle vara bra att samla i någon Utils eller liknande.
    // TODO: Check whether we need this method or not, just a temporary fix
    fun getEnumType(text: String): YesAndNoAndNoAnswer {
        return when (text) {
            "Ja" -> YesAndNoAndNoAnswer.YES
            "Nej" -> YesAndNoAndNoAnswer.NO
            "Inget svar" -> YesAndNoAndNoAnswer.NO_ANSWER
            else -> YesAndNoAndNoAnswer.UNKOWN
        }
    }

    // TODO: Check whether we need this method or not, just a temporary fix
    fun getEnumString(yesAndNoAndNoAnswer: YesAndNoAndNoAnswer): String {
        return when (yesAndNoAndNoAnswer) {
            YesAndNoAndNoAnswer.YES -> "Ja"
            YesAndNoAndNoAnswer.NO -> "Nej"
            YesAndNoAndNoAnswer.NO_ANSWER -> "Inget svar"
            else -> "Unknown"
        }
    }

    fun getBooleanValue(value: String): Boolean {
        return value == "Ja"
    }
}
