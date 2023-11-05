package fr.groupe4.bookmyspace_front_mobile.ui

import android.app.Application
import fr.groupe4.bookmyspace_front_mobile.di.dataModule
import fr.groupe4.bookmyspace_front_mobile.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BookMySpaceApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // declare used Android context
            androidContext(this@BookMySpaceApplication)
            // declare modules
            modules(dataModule)
            modules(domainModule)
        }
    }
}