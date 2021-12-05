package com.project.mvvmnewsapp.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.project.mvvmnewsapp.ui.NewsActivity
import com.project.mvvmnewsapp.ui.NewsViewModel

import project.mvvmnewsapp.R

class SavedNewsFragment : Fragment(R.layout.fragment_saved_news) {
    private lateinit var viewModel : NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
    }
}