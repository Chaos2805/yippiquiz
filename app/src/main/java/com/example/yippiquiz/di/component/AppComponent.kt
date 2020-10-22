package com.example.yippiquiz.di.component

import com.example.yippiquiz.BaseApp
import com.example.yippiquiz.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface AppComponent {

    fun inject(application: BaseApp)

}