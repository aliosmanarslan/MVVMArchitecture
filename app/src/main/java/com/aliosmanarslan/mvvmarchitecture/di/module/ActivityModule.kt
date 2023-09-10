package com.aliosmanarslan.mvvmarchitecture.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.HasDefaultViewModelProviderFactory
import androidx.lifecycle.ViewModelProvider
import com.aliosmanarslan.mvvmarchitecture.data.repository.TopHeadlineRepository
import com.aliosmanarslan.mvvmarchitecture.di.ActivityContext
import com.aliosmanarslan.mvvmarchitecture.ui.base.ViewModelProviderFactory
import com.aliosmanarslan.mvvmarchitecture.ui.topheadline.TopHeadlineAdapter
import com.aliosmanarslan.mvvmarchitecture.ui.topheadline.TopHeadlineViewModel
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return activity
    }

    @Provides
    fun provideTopHeadlineViewModel(topHeadlineRepository: TopHeadlineRepository): TopHeadlineViewModel {
        return ViewModelProvider(activity,
            ViewModelProviderFactory(TopHeadlineViewModel::class) {
                TopHeadlineViewModel(topHeadlineRepository)
            })[TopHeadlineViewModel::class.java]
    }

    @Provides
    fun provideTopHeadlineAdapter() = TopHeadlineAdapter(ArrayList())

}