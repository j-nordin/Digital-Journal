package com.EENX15_22_17.digital_journal.android.screens.triage.contactreason

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    val resource = ContactReason(JournalEntries.Id(journalId))

    private val _contactReason = MutableStateFlow(ContactReasonDto())
    var contactReason = _contactReason.asStateFlow()

    init {
        update()
    }

    fun save(contactReason: ContactReasonDto) {
        viewModelScope.launch {
            client.saveResource(resource, contactReason)
        }.invokeOnCompletion {
            // TODO: This should not be done if saving fails as this would overwrite any progress.
            update()
        }
    }

    // FIXME: Is this really the awy forwards?
    fun saveSbar(sbar: ContactReasonDto.SBAR) {
        save(contactReason.value.copy(sbar = sbar))
    }

    fun update() {
        viewModelScope.launch {
            val data: ContactReasonDto = client.getResource(resource)
            _contactReason.emit(data)
        }
    }

}