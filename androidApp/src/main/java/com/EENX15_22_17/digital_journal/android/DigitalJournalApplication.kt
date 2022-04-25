package com.EENX15_22_17.digital_journal.android

import android.app.Application
import org.kodein.di.*
import org.kodein.di.android.androidCoreModule
import org.kodein.di.android.x.androidXModule

class DigitalJournalApplication: Application(), DIAware {

    override val di: DI by DI.lazy {
        fullDescriptionOnError = true
        fullContainerTreeOnError = true

        import(androidCoreModule(this@DigitalJournalApplication))
        import(androidXModule(this@DigitalJournalApplication))

    }

}