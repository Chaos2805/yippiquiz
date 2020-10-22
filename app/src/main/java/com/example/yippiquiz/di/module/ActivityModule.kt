package com.example.yippiquiz.di.module

import android.app.Activity
import com.example.yippiquiz.contract.MainContract
import com.example.yippiquiz.presenter.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenter(): MainContract.Presenter {
        return MainPresenter()
    }

}