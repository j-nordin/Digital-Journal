package com.EENX15_22_17.digital_journal.android.screens.journallisting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import se.predicare.journal.data.JournalEntryDto
import se.predicare.journal.repository.JournalRepository

class JournalListingViewModel(
    val journalRepo: JournalRepository
): ViewModel() {

    private val _journals = MutableStateFlow<List<JournalEntryDto>>(emptyList())
    val journals = _journals.asStateFlow()

    init {
        refresh()
    }

    fun createNew(journalEntryDto: JournalEntryDto) {
        viewModelScope.launch {
            journalRepo.create(journalEntryDto)
        }.invokeOnCompletion {
            refresh()
        }
    }

    fun refresh(){
        viewModelScope.launch {
            _journals.emit(journalRepo.get())
        }
    }

}