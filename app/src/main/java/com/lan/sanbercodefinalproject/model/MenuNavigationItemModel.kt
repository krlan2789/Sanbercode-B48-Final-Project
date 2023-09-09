package com.lan.sanbercodefinalproject.model

import com.lan.sanbercodefinalproject.R

sealed class MenuNavigationItemModel(var route: String, var icon: Int, var title: String) {
    object Home : MenuNavigationItemModel("home", R.drawable.baseline_home_24, "Home")
    object Teams : MenuNavigationItemModel("teams", R.drawable.ic_teams, "Teams")
    object Players : MenuNavigationItemModel("players", R.drawable.ic_soccer_player, "Players")
    object Leagues : MenuNavigationItemModel("leagues", R.drawable.baseline_emoji_events_24, "Leagues")
    object News : MenuNavigationItemModel("news", R.drawable.baseline_newspaper_24, "News")
    object Matches : MenuNavigationItemModel("matches", R.drawable.ic_account_tree, "Matches")

    fun getPair() : Pair<String, String> {
        return Pair(route, title)
    }
}
