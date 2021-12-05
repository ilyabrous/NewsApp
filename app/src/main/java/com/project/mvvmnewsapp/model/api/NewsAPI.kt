package com.project.mvvmnewsapp.model.api

import com.project.Constants.Companion.BASE_URL
import com.project.mvvmnewsapp.model.util.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("/v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode : String = "ru",
        @Query("page")
        pageNumber : Int = 1,
        @Query("apiKey")
        apiKey : String = BASE_URL
    ) : Response<NewsResponse>

    @GET("/v2/everything")
    suspend fun searchForNews(
        @Query("q")
        searchQuery : String,
        @Query("page")
        pageNumber : Int = 1,
        @Query("apiKey")
        apiKey : String = BASE_URL
    ) : Response<NewsResponse>

}