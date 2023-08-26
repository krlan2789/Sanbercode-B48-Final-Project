package com.lan.sanbercodefinalproject.ui.shared.navigations

import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lan.sanbercodefinalproject.model.MenuNavigationItemModel
import com.lan.sanbercodefinalproject.ui.menu.home.HomeScreenUI
import com.lan.sanbercodefinalproject.ui.menu.leagues.LeaguesScreenUI
import com.lan.sanbercodefinalproject.ui.menu.teams.TeamsScreenUI
import com.lan.sanbercodefinalproject.viewmodel.ArticlesViewModel
import com.lan.sanbercodefinalproject.viewmodel.LeaguesViewModel
import com.lan.sanbercodefinalproject.viewmodel.TeamsViewModel

@Composable
fun MenuNavigationUI(
    navController: NavHostController,
    activity: ComponentActivity,
    articlesViewModel: ArticlesViewModel? = null,
    teamsViewModel: TeamsViewModel? = null,
    leaguesViewModel: LeaguesViewModel? = null
) {
    NavHost(navController, startDestination = MenuNavigationItemModel.Home.route) {
        composable(MenuNavigationItemModel.Home.route) {
            Log.i("MenuNavigationUI", "Home.route: " + it.id)
            if (articlesViewModel != null) HomeScreenUI(articlesViewModel, activity)
        }
        composable(MenuNavigationItemModel.Teams.route) {
            Log.i("MenuNavigationUI", "Teams.route: " + it.id)
            if (teamsViewModel != null) TeamsScreenUI(teamsViewModel, activity)
        }
        composable(MenuNavigationItemModel.Leagues.route) {
            Log.i("MenuNavigationUI", "Leagues.route: " + it.id)
            if (leaguesViewModel != null) LeaguesScreenUI(leaguesViewModel, activity)
        }
        composable(MenuNavigationItemModel.Players.route) {
            Log.i("MenuNavigationUI", "Players.route: " + it.id)
        }
    }
}