package com.EENX15_22_17.digital_journal.android.data

import com.EENX15_22_17.digital_journal.android.screens.journal.JournalEntryViewModel
import com.EENX15_22_17.digital_journal.android.screens.journalList.JournalListViewModel
import org.kodein.di.DI
import org.kodein.di.bindMultiton
import org.kodein.di.bindSingleton
import org.kodein.di.instance

val ViewModelModule = DI.Module("ViewModelModule") {

    bindSingleton { JournalListViewModel(instance()) }

    bindMultiton<String, JournalEntryViewModel> { journalId ->
        JournalEntryViewModel(journalRepository = instance(), journalId = journalId)
    }

}