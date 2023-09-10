package com.aliosmanarslan.mvvmarchitecture.di.component

import android.content.Context
import com.aliosmanarslan.mvvmarchitecture.MVVMApplication
import com.aliosmanarslan.mvvmarchitecture.data.api.NetworkService
import com.aliosmanarslan.mvvmarchitecture.data.repository.TopHeadlineRepository
import com.aliosmanarslan.mvvmarchitecture.di.ApplicationContext
import com.aliosmanarslan.mvvmarchitecture.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: MVVMApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getTopHeadlineRepository(): TopHeadlineRepository

}