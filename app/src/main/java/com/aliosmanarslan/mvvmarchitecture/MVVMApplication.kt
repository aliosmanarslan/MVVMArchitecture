package com.aliosmanarslan.mvvmarchitecture

import android.app.Application
import com.aliosmanarslan.mvvmarchitecture.di.component.DaggerApplicationComponent
import com.aliosmanarslan.mvvmarchitecture.di.component.ApplicationComponent
import com.aliosmanarslan.mvvmarchitecture.di.module.ApplicationModule

class MVVMApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}