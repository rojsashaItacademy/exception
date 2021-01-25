package ru.trinitydigital.errorhandling

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.trinitydigital.errorhandling.di.appModules

class ErrorHandlingApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ErrorHandlingApp)
            modules(appModules)
        }
    }
}