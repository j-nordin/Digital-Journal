package com.EENX15_22_17.digital_journal.android.data

import com.EENX15_22_17.digital_journal.android.screens.JournalEventViewModel
import com.EENX15_22_17.digital_journal.android.screens.journallisting.JournalListingViewModel
import com.EENX15_22_17.digital_journal.android.screens.triage.contactreason.ContactReasonViewModel
import org.kodein.di.DI
import org.kodein.di.bindMultiton
import org.kodein.di.bindSingleton
import org.kodein.di.instance

val ViewModelModule = DI.Module("ViewModelModule") {

    bindSingleton { JournalListingViewModel(instance()) }

    bindMultiton<String, ContactReasonViewModel> { journalId ->
        ContactReasonViewModel(client = instance("azure"), journalId)
    }

    bindMultiton<String, JournalEventViewModel> { journalId ->
        JournalEventViewModel(journalRepository = instance(), journalId)
    }

}