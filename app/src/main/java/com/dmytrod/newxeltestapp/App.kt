package com.dmytrod.newxeltestapp

import android.app.Application

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .build()
    }
}
