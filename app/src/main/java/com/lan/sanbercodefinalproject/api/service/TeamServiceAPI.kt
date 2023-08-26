package com.lan.sanbercodefinalproject.api.service

import com.lan.sanbercodefinalproject.api.config.FootballConfigAPI
import com.lan.sanbercodefinalproject.model.response.ResponseTeams
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TeamServiceAPI {
    @GET("${FootballConfigAPI.apiKey}met=Teams")
    fun getTeams(@Query("leagueId") leagueId: String) : Call<ResponseTeams>
}