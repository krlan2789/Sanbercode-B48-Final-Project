package com.lan.sanbercodefinalproject.api.config

import com.lan.sanbercodefinalproject.api.service.ArticleServiceAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FootballArticleConfigAPI {
    private const val baseUrl = "https://newsapi.org/v2/top-headlines/"
    const val apiKey = "?apiKey=dc849d84b84e4c9695e6d0509833a9d5&"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val articlesService: ArticleServiceAPI by lazy {
        retrofit.create(ArticleServiceAPI::class.java)
    }
}