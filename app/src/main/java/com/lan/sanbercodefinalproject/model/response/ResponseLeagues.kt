package com.lan.sanbercodefinalproject.model.response

import com.google.gson.annotations.SerializedName

data class ResponseLeagues(

	@field:SerializedName("result")
	val result: List<ResultLeagueItem> = listOf(),

	@field:SerializedName("success")
	val success: Int = 0
)

data class ResultLeagueItem(

	@field:SerializedName("country_key")
	val countryKey: String? = "",

	@field:SerializedName("league_name")
	val leagueName: String? = "",

	@field:SerializedName("league_logo")
	val leagueLogo: String? = "",

	@field:SerializedName("country_name")
	val countryName: String? = "",

	@field:SerializedName("league_key")
	val leagueKey: String? = "",

	@field:SerializedName("country_logo")
	val countryLogo: String? = ""
)
