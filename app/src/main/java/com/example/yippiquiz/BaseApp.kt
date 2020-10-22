package com.example.yippiquiz

import android.app.Application
import com.example.yippiquiz.di.component.AppComponent
import com.example.yippiquiz.di.component.DaggerAppComponent
import com.example.yippiquiz.di.module.ApplicationModule

class BaseApp: Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        instance = this
        setup()
    }

    fun setup() {
        component = DaggerAppComponent.builder()
            .applicationModule(ApplicationModule(this)).build()
        component.inject(this)
    }

    fun getApplicationComponent(): AppComponent {
        return component
    }

    companion object {
        lateinit var instance: BaseApp private set
    }
}