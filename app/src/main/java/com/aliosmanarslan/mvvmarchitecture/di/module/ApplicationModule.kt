package com.aliosmanarslan.mvvmarchitecture.di.module

import android.content.Context
import com.aliosmanarslan.mvvmarchitecture.MVVMApplication
import com.aliosmanarslan.mvvmarchitecture.data.api.NetworkService
import com.aliosmanarslan.mvvmarchitecture.di.ApplicationContext
import com.aliosmanarslan.mvvmarchitecture.di.BaseUrl
import com.aliosmanarslan.mvvmarchitecture.utils.AppConstant.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: MVVMApplication) {

    @ApplicationContext
    @Provides
    fun provideContext(): Context {
        return application
    }

    @BaseUrl
    @Provides
    fun provideBaseUrl(): String = BASE_URL

    @Provides
    @Singleton
    fun provideGsonConverterFactory():GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideNetworkService(
        @BaseUrl baseUrl: String,
        gsonConverterFactory: GsonConverterFactory
    ): NetworkService {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(gsonConverterFactory)
            .build()
            .create(NetworkService::class.java)
    }
}