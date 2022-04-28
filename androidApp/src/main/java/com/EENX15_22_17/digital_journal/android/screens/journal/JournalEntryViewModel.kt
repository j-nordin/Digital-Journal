package com.EENX15_22_17.digital_journal.android.screens.journal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import se.predicare.journal.data.JournalEntryDto
import se.predicare.journal.repository.JournalRepository

class JournalEntryViewModel(
    val journalRepository: JournalRepository,
    val journalId: String
): ViewModel() {

    // TODO: Is it a good idea to initialize with default instance?
    private val _journal = MutableStateFlow(JournalEntryDto())
    val journal = _journal.asStateFlow()

    init {
        update()
    }

    fun update() {
        viewModelScope.launch {
            val journalEntryDto = journalRepository.get(journalId)
            journalEntryDto?.let {
                _journal.emit(it)
            }
        }
    }

}