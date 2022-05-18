package com.EENX15_22_17.digital_journal.android.screens.journal.arrival.patientInfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.EENX15_22_17.digital_journal.android.data.MutableStateProviderFromModel
import io.ktor.client.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import se.predicare.journal.getResource
import se.predicare.journal.routes.JournalEntries
import se.predicare.journal.routes.PatientInfo
import se.predicare.journal.saveResource
import se.predicare.journal.screens.PatientInformationDto

class PatientInfoViewModel(
    val client: HttpClient,
    val journalId: String
) : ViewModel() {

    val resource = PatientInfo(id = JournalEntries.Id(journalId))

    private var _patientInfo = MutableStateFlow(PatientInformationDto())
    var patientInfo = _patientInfo.asStateFlow()

    val data = MutableStateProviderFromModel(PatientInformationDto())


    fun update() {
        viewModelScope.launch {
            val patientInfoDto: PatientInformationDto = client.getResource(resource)
            _patientInfo.emit(patientInfoDto)
            data.model = patientInfoDto
        }
    }

    fun save() {
        viewModelScope.launch {
            //data.saveStatesToModel()
            client.saveResource(resource, data.model)
        }.invokeOnCompletion {
            //update()
        }
    }


/*    fun getTimestamp(): String {
        val dateToFormat = this.arrivalStates.date.toString()
        return dateToFormat.subSequence(0, 10).toString()
    }*/
}
