package com.lan.sanbercodefinalproject.api.service

import com.lan.sanbercodefinalproject.api.config.FootballArticleConfigAPI
import com.lan.sanbercodefinalproject.model.response.ResponseArticles
import retrofit2.Call
import retrofit2.http.GET

interface ArticleServiceAPI {
    @GET("${FootballArticleConfigAPI.apiKey}sources=espn")
    fun getFromESPN() : Call<ResponseArticles>
}
