package com.EENX15_22_17.digital_journal.android.data

import com.EENX15_22_17.digital_journal.android.screens.JournalEventViewModel
import com.EENX15_22_17.digital_journal.android.screens.current.currentpatients.PatientListViewModel
import org.kodein.di.DI
import org.kodein.di.bindMultiton
import org.kodein.di.bindSingleton
import org.kodein.di.instance

val ViewModelModule = DI.Module("ViewModelModule") {

    bindSingleton { PatientListViewModel(instance()) }

    bindMultiton<String, JournalEventViewModel> { journalId ->
        JournalEventViewModel(journalRepository = instance(), journalId = journalId)
    }

    bindSingleton { JournalEventViewModel(instance(), "626803fd7f788d66486d6561") }
}