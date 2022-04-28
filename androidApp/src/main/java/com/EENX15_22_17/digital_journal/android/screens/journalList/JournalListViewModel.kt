package com.EENX15_22_17.digital_journal.android.screens.journalList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import se.predicare.journal.data.JournalEntryDto
import se.predicare.journal.repository.JournalRepository

class JournalListViewModel(
    val journalRepo: JournalRepository
): ViewModel() {

    private val _journals = MutableStateFlow<List<JournalEntryDto>>(emptyList())
    val journals = _journals.asStateFlow()

    init {
        refresh()
    }

    fun refresh(){
        viewModelScope.launch {
            _journals.emit(journalRepo.get())
        }
    }

}