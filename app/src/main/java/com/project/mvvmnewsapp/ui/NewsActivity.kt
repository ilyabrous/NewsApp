package com.project.mvvmnewsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.project.mvvmnewsapp.NewsApp
import com.project.mvvmnewsapp.model.db.ArticleDatabase
import com.project.mvvmnewsapp.model.repository.NewsRepository
import kotlinx.android.synthetic.main.activity_news.*
import project.mvvmnewsapp.R

class NewsActivity : AppCompatActivity() {

    lateinit var viewModel : NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val newsRepository = NewsRepository(ArticleDatabase(applicationContext))
        val newsViewModelFactory = NewsViewModelFactory(application, newsRepository)
        viewModel = ViewModelProvider(this, newsViewModelFactory).get(NewsViewModel::class.java)
        bottomNavigationView.setupWithNavController(newNavHostFragment.findNavController())

    }
}
