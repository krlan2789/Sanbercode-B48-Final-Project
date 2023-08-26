package com.lan.sanbercodefinalproject.api.service

import com.lan.sanbercodefinalproject.api.config.FootballConfigAPI
import com.lan.sanbercodefinalproject.model.response.ResponseLeagues
import retrofit2.Call
import retrofit2.http.GET

interface LeagueServiceAPI {
    @GET("${FootballConfigAPI.apiKey}met=Leagues")
    fun getLeagues() : Call<ResponseLeagues>
}
