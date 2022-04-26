package com.EENX15_22_17.digital_journal.android

import android.app.Application
import com.EENX15_22_17.digital_journal.android.data.ViewModelModule
import io.ktor.client.*
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.androidCoreModule
import org.kodein.di.android.x.androidXModule
import org.kodein.di.bindSingleton
import org.kodein.di.instance
import se.predicare.journal.JournalClient
import se.predicare.journal.auth.JournalApiUser
import se.predicare.journal.getKtorHttpClient
import se.predicare.journal.repository.JournalRepository

class DigitalJournalApplication: Application(), DIAware {

    override val di: DI by DI.lazy {
        fullDescriptionOnError = true
        fullContainerTreeOnError = true

        import(androidCoreModule(this@DigitalJournalApplication))
        import(androidXModule(this@DigitalJournalApplication))


        bindSingleton { JournalApiUser("JournalApiUser", "zNt62knGmW") }

        bindSingleton<HttpClient>("local") {
            getKtorHttpClient("http://localhost:8086/api/v1/", instance())
        }

        bindSingleton<HttpClient>("azure") {
            getKtorHttpClient("https://predicare-journal.azurewebsites.net/api/v1/", instance())
        }

        bindSingleton<JournalRepository> { JournalClient(client = instance("azure")) }

        import(ViewModelModule)

    }

}