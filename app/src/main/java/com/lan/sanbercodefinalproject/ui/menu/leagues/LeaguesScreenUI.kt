package com.lan.sanbercodefinalproject.ui.menu.leagues

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.lan.sanbercodefinalproject.activity.BaseActivity
import com.lan.sanbercodefinalproject.activity.MainActivity
import com.lan.sanbercodefinalproject.ui.shared.ContentListUI
import com.lan.sanbercodefinalproject.ui.shared.NoResultsUI
import com.lan.sanbercodefinalproject.ui.shared.ShowProgressIndicator
import com.lan.sanbercodefinalproject.ui.shared.navigations.MenuNavigationTopUI
import com.lan.sanbercodefinalproject.ui.theme.SanbercodeFinalProjectTheme
import com.lan.sanbercodefinalproject.viewmodel.LeaguesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LeaguesScreenUI(viewModel: LeaguesViewModel, activity: BaseActivity, navController: NavController? = null) {
    val leagues by viewModel.leagues.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchTeams()
    }

    Scaffold(
        topBar = { MenuNavigationTopUI(activity = activity, title = "Leagues", navController = navController) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            ContentListUI(contentItems = leagues) { league ->
                if (league.leagueKey?.isNotEmpty() == true) {
                    LeagueCardUI(data = league)
                }
                else {
                    Box(modifier = Modifier.padding(32.dp)) { NoResultsUI("No leagues registered") }
                }
            }
        }
        ShowProgressIndicator(leagues.isEmpty())
    }
}

@Preview
@Composable
private fun Preview() {
    SanbercodeFinalProjectTheme {
        LeaguesScreenUI(LeaguesViewModel(), MainActivity::class.java.newInstance())
    }
}
