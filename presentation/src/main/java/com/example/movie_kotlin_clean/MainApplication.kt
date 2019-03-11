package com.example.movie_kotlin_clean

import android.app.Application
import com.example.movie_kotlin_clean.di.modules
import org.koin.android.ext.android.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, modules)
    }
}
