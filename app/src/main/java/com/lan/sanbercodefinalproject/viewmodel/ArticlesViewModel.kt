package com.lan.sanbercodefinalproject.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lan.sanbercodefinalproject.api.config.FootballArticleConfigAPI
import com.lan.sanbercodefinalproject.model.response.ResponseArticles
import com.lan.sanbercodefinalproject.model.response.ResultArticlesItem
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticlesViewModel : ViewModel() {
    private val _articles = MutableLiveData<List<ResultArticlesItem>>()
    val articles: LiveData<List<ResultArticlesItem>> = _articles

    fun fetchArticles() {
        viewModelScope.launch {
            try {
                FootballArticleConfigAPI.articlesService.getFromESPN().enqueue(object :
                    Callback<ResponseArticles> {
                    override fun onResponse(call: Call<ResponseArticles>, response: Response<ResponseArticles>) {
                        Log.i("ArticlesViewModel.onResponse", response.message())
                        if (response.isSuccessful) {
                            Log.i("ArticlesViewModel", response.body()!!.toString())
                            if (response.body() != null) _articles.value = response.body()!!.articles
                        }
                    }

                    override fun onFailure(call: Call<ResponseArticles>, t: Throwable) {
                        Log.w("ArticlesViewModel.onFailure", "Data not Found")
                    }
                })
            } catch (e: Exception) {
                Log.e("ArticlesViewModel", "TeamsViewModel.fetchArticles: " + e.message)
            }
        }
    }
}