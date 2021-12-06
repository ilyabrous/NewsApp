package com.project.mvvmnewsapp.model.util


data class NewsResponse(
    val articles: MutableList<Article> = mutableListOf(),
    val status: String = "",
    val totalResults: Int = 0
)