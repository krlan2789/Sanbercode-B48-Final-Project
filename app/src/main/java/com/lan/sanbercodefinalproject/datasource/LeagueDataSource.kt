package com.lan.sanbercodefinalproject.datasource

import com.lan.sanbercodefinalproject.model.response.ResultLeagueItem

object LeagueDataSource {
    fun loadLeagues(): List<ResultLeagueItem> {
        return listOf(
            ResultLeagueItem(leagueKey = "148", leagueName = "Premier League", countryKey = "41", countryName = "England", leagueLogo = "https://allsportsapi.com/logo/logo_leagues/512_1.-lig.png"),
            ResultLeagueItem(leagueKey = "195", leagueName = "Bundesliga", countryKey = "51", countryName = "Germany", leagueLogo = "https://allsportsapi.com/logo/logo_leagues/195_bundesliga.png"),
            ResultLeagueItem(leagueKey = "423", leagueName = "Premiership", countryKey = "124", countryName = "Scotland", leagueLogo = "https://allsportsapi.com/logo/logo_leagues/423_premiership.png"),
            ResultLeagueItem(leagueKey = "176", leagueName = "Ligue 1", countryKey = "46", countryName = "France", leagueLogo = "https://allsportsapi.com/logo/logo_leagues/176_ligue-1.png"),
            ResultLeagueItem(leagueKey = "177", leagueName = "Ligue 2", countryKey = "46", countryName = "France", leagueLogo = "https://allsportsapi.com/logo/logo_leagues/177_ligue-2.png")
        )
    }

    fun loadLeague(leagueKey: String?): ResultLeagueItem? {
        if (leagueKey != null) {
            for (l in loadLeagues()) {
                if (leagueKey.isNotEmpty() && l.leagueKey == leagueKey) return l
            }
        }
        return null
    }
}