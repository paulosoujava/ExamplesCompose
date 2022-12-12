package com.jorge.paulo

import android.app.Application
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(com.jorge.paulo.jokeapp.koin.appModule)
        }
    }
}