package com.lan.sanbercodefinalproject.ui.shared.navigations

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lan.sanbercodefinalproject.activity.MainActivity
import com.lan.sanbercodefinalproject.model.MenuNavigationItemModel
import com.lan.sanbercodefinalproject.ui.menu.home.HomeScreenUI
import com.lan.sanbercodefinalproject.ui.menu.leagues.LeaguesScreenUI
import com.lan.sanbercodefinalproject.ui.menu.teams.TeamsScreenUI
import com.lan.sanbercodefinalproject.viewmodel.ArticlesViewModel
import com.lan.sanbercodefinalproject.viewmodel.LeaguesViewModel
import com.lan.sanbercodefinalproject.viewmodel.TabLayoutViewModel
import com.lan.sanbercodefinalproject.viewmodel.TeamsViewModel

@Composable
fun MenuNavigationUI(
    navController: NavHostController,
    activity: MainActivity,
) {
    val articlesViewModel: ArticlesViewModel = activity.articlesViewModel
    val teamsViewModel: TeamsViewModel = activity.teamsViewModel
    val leaguesViewModel: LeaguesViewModel = activity.leaguesViewModel
    val tabLayoutViewModel: TabLayoutViewModel = activity.tabLayoutViewModel

    NavHost(navController, startDestination = MenuNavigationItemModel.Home.route) {
        composable(MenuNavigationItemModel.Home.route) {
            Log.i("MenuNavigationUI", "Home.route: " + it.destination.route)
            HomeScreenUI(articlesViewModel, activity)
        }
        composable(MenuNavigationItemModel.Teams.route) {
            Log.i("MenuNavigationUI", "Teams.route: " + it.destination.route)
            TeamsScreenUI(teamsViewModel, tabLayoutViewModel, activity, navController)
        }
        composable(MenuNavigationItemModel.Leagues.route) {
            Log.i("MenuNavigationUI", "Leagues.route: " + it.destination.route)
            LeaguesScreenUI(leaguesViewModel, activity, navController)
        }
        composable(MenuNavigationItemModel.Players.route) {
            Log.i("MenuNavigationUI", "Players.route: " + it.destination.route)
        }
    }
}