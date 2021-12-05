package com.project.mvvmnewsapp.model.util


data class NewsResponse(
    val articles: List<Article> = listOf(),
    val status: String = "",
    val totalResults: Int = 0
)