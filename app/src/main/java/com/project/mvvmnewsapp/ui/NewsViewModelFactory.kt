package com.project.mvvmnewsapp.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.mvvmnewsapp.NewsApp
import com.project.mvvmnewsapp.model.repository.NewsRepository

class NewsViewModelFactory(
    private val app: Application,
    private val newsRepository: NewsRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(app , newsRepository = newsRepository) as T
    }
}