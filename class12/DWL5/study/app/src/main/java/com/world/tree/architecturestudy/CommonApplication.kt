package com.world.tree.architecturestudy

import android.app.Application
import org.koin.core.context.startKoin

class CommonApplication:Application() {
    val movieContainer = MovieContainer()
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule)
        }
    }
}