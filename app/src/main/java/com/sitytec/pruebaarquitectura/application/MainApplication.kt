package com.sitytec.pruebaarquitectura.application

import android.app.Application
import com.sitytec.pruebaarquitectura.features.remisiones.module.remModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        injectDependencies()
    }

    private fun injectDependencies() {
        val modules = listOf(
            remModule
        )
        startKoin {
            modules(modules)
            androidContext(this@MainApplication)
        }
    }
}