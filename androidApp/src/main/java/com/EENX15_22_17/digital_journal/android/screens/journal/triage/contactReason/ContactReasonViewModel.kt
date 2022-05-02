package com.EENX15_22_17.digital_journal.android.screens.journal.triage.contactReason

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.EENX15_22_17.digital_journal.android.data.MutableStateProviderFromModel
import io.ktor.client.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import se.predicare.journal.getResource
import se.predicare.journal.routes.ContactReason
import se.predicare.journal.routes.JournalEntries
import se.predicare.journal.saveResource
import se.predicare.journal.screens.ContactReasonDto

class ContactReasonViewModel(
    val client: HttpClient,
    val journalId: String
): ViewModel() {

    val resource = ContactReason(id = JournalEntries.Id(journalId))

    private var _contactReason = MutableStateFlow(ContactReasonDto())
    val contactReason = _contactReason.asStateFlow()

    fun update() {
        viewModelScope.launch {
            val contactReasonDto: ContactReasonDto = client.getResource(resource)
            _contactReason.emit(contactReasonDto)
            data.model = contactReasonDto
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

    val data = MutableStateProviderFromModel(ContactReasonDto())

}
