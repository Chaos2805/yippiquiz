package com.example.yippiquiz.di.module

import android.app.Application
import android.content.Context
import com.example.yippiquiz.BaseApp
import com.example.yippiquiz.di.scope.PerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val baseApp: BaseApp) {

    @Provides
    @Singleton
    @PerApplication
    fun provideApplication(): Application {
        return baseApp
    }
}