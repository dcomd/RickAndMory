package com.demo.android.alexandre.rickandmortycardapp

import android.app.Application
import com.demo.android.alexandre.rickandmortycardapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class StartKoinAp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin{
            androidLogger()
            androidContext(this@StartKoinAp)
            modules(listOf(appModule))
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        stopKoin()
    }
}