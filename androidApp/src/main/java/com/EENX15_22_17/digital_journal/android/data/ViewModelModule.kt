package com.EENX15_22_17.digital_journal.android.data

import com.EENX15_22_17.digital_journal.android.screens.current.currentpatients.PatientListViewModel
import com.EENX15_22_17.digital_journal.android.screens.landingpage.LandingPageViewModel
import org.kodein.di.DI
import org.kodein.di.bindMultiton
import org.kodein.di.bindSingleton
import org.kodein.di.instance

val ViewModelModule = DI.Module("ViewModelModule") {

    bindSingleton { PatientListViewModel(instance()) }

    bindMultiton<String, LandingPageViewModel> { journalId ->
        LandingPageViewModel(instance(), journalid = journalId)
    }

    // bindSingleton { LandingPageViewModel(instance(),"626803fd7f788d66486d6561") }
}