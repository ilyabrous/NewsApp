package com.project.mvvmnewsapp.model.repository

import com.project.mvvmnewsapp.model.db.ArticleDatabase
import com.project.mvvmnewsapp.model.util.NewsResponse
import com.project.mvvmnewsapp.model.util.RetrofitInstance
import retrofit2.Response

class NewsRepository(
    val db: ArticleDatabase
) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int): Response<NewsResponse> {
        return RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)
    }

    suspend fun searchNews(searchQuery : String, pageNumber: Int): Response<NewsResponse> {
        return RetrofitInstance.api.searchForNews(searchQuery, pageNumber)
    }

}