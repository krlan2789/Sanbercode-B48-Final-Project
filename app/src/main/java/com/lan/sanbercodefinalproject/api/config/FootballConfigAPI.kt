package com.lan.sanbercodefinalproject.api.config

import com.lan.sanbercodefinalproject.api.service.LeagueServiceAPI
import com.lan.sanbercodefinalproject.api.service.PlayerServiceAPI
import com.lan.sanbercodefinalproject.api.service.TeamServiceAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FootballConfigAPI {
    private const val baseUrl = "https://allsportsapi.com/api/football/"
    const val apiKey = "?APIkey=d57213105b3df1b7968af085d531df65d806acef5c76b9d116345fa47e3d05d3&"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val leaguesService: LeagueServiceAPI by lazy {
        retrofit.create(LeagueServiceAPI::class.java)
    }

    val teamsService: TeamServiceAPI by lazy {
        retrofit.create(TeamServiceAPI::class.java)
    }

    val playersService: PlayerServiceAPI by lazy {
        retrofit.create(PlayerServiceAPI::class.java)
    }
}
