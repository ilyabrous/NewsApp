package com.project.mvvmnewsapp.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.mvvmnewsapp.Resource
import com.project.mvvmnewsapp.model.repository.NewsRepository
import com.project.mvvmnewsapp.model.util.NewsResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(
    val newsRepository : NewsRepository
) : ViewModel() {

    val breakingNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var breakingNewsPage = 1

    init {
        getBreakingNews("ru")
    }

    fun getBreakingNews(countyCode: String){
        Log.d("LOG-TAG", "getBreakingNews: startedBreaking")
        viewModelScope.launch {
            breakingNews.postValue(Resource.Loading ())
            val response = newsRepository.getBreakingNews(countyCode, breakingNewsPage)
            Log.d("LOG-TAG", "getBreakingNews: response = ${response.code()}")
            breakingNews.postValue(handleBreakingNewsResponse(response))
        }

    }

    private fun handleBreakingNewsResponse(response: Response<NewsResponse>) : Resource<NewsResponse> {
        if (response.isSuccessful) {
           response.body()?.let { resultResponse ->
               return Resource.Success(resultResponse)
           }
        }
        return Resource.Error(message = response.message())
    }
}