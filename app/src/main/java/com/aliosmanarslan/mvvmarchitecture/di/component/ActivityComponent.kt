package com.aliosmanarslan.mvvmarchitecture.di.component

import com.aliosmanarslan.mvvmarchitecture.di.ActivityScope
import com.aliosmanarslan.mvvmarchitecture.di.module.ActivityModule
import com.aliosmanarslan.mvvmarchitecture.ui.topheadline.TopHeadlineActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: TopHeadlineActivity)

}