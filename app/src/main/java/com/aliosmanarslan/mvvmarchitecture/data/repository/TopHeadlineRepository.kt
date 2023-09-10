package com.aliosmanarslan.mvvmarchitecture.data.repository

import com.aliosmanarslan.mvvmarchitecture.data.api.NetworkService
import com.aliosmanarslan.mvvmarchitecture.data.model.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

import javax.inject.Inject

class TopHeadlineRepository @Inject constructor(
    private val networkService: NetworkService) {

    fun getTopHeadlines(country: String): Flow<List<Article>> {
        return flow {
            emit(networkService.getTopHeadlines(country))
        }.map {
            it.articles
        }
    }
}