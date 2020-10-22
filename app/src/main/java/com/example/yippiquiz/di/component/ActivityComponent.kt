package com.example.yippiquiz.di.component

import com.example.yippiquiz.di.module.ActivityModule
import com.example.yippiquiz.view.ActivityItemDetails
import com.example.yippiquiz.view.MainActivity
import dagger.Component

@Component(modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(activityItemDetails: ActivityItemDetails)

}