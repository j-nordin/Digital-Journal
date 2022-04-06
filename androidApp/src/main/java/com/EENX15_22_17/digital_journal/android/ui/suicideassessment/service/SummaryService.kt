package com.EENX15_22_17.digital_journal.android.ui.suicideassessment.service

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object SummaryService {
    var suicideStepSum by mutableStateOf(0)
    var riskFactorSum by mutableStateOf(0)
    var protectiveFactorSum by mutableStateOf(0)

    fun updateSummaryValue(whichSection : String, checkBoxValue : Boolean) {
        when (whichSection) {
            "suicidesteps" -> this.suicideStepSum = updateValue(this.suicideStepSum, checkBoxValue)
            "riskfactors" -> this.riskFactorSum = updateValue(this.riskFactorSum, checkBoxValue)
            "protectivefactors" -> this.protectiveFactorSum = updateValue(this.protectiveFactorSum, checkBoxValue)
        }
    }

    private fun updateValue(whichSectionValue: Int, checkBoxValue: Boolean)  : Int {
        var number = whichSectionValue
        if ((number == 0) && (!checkBoxValue))
            return 0;
        number = if (!checkBoxValue)
            number - 1;
        else
            number + 1;
        return  number;
    }



}