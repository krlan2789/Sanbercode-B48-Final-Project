package com.lan.sanbercodefinalproject.model.response

import com.google.gson.annotations.SerializedName

data class ResponseArticles(

	@field:SerializedName("totalResults")
	val totalResults: Int = 0,

	@field:SerializedName("articles")
	val articles: List<ResultArticlesItem> = listOf(),

	@field:SerializedName("status")
	val status: String = ""
)

data class ResultArticlesItem(

	@field:SerializedName("publishedAt")
	val publishedAt: String? = "",

	@field:SerializedName("author")
	val author: String? = "",

	@field:SerializedName("urlToImage")
	val urlToImage: String? = "",

	@field:SerializedName("description")
	val description: String? = "",

	@field:SerializedName("source")
	val source: Source? = null,

	@field:SerializedName("title")
	val title: String? = "",

	@field:SerializedName("url")
	val url: String? = "",

	@field:SerializedName("content")
	val content: String? = ""
)

data class Source(

	@field:SerializedName("name")
	val name: String? = "",

	@field:SerializedName("id")
	val id: String? = ""
)
