package com.world.tree.architecturestudy

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CommonApplication:Application() {
    val movieContainer = MovieContainer()
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@CommonApplication)
            modules(appModule)
        }
    }
}