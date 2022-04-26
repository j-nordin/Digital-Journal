package com.EENX15_22_17.digital_journal.android.screens.interim

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import se.predicare.journal.data.YesNoQuestion
import se.predicare.journal.screens.InterimJournalDto

class InterimViewModel : ViewModel() {
    var interimStates by mutableStateOf(InterimJournalDto())

    //TODO: Remove when they are included in InterimDto
    var department by mutableStateOf("")
    var ssk by mutableStateOf("")
    var time by mutableStateOf("")
    var admission by mutableStateOf(YesNoQuestion.UNANSWERED)

}