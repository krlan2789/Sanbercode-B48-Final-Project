package com.lan.sanbercodefinalproject.ui.menu.teams

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.google.gson.Gson
import com.lan.sanbercodefinalproject.activity.BaseActivity
import com.lan.sanbercodefinalproject.activity.MainActivity
import com.lan.sanbercodefinalproject.activity.PlayersActivity
import com.lan.sanbercodefinalproject.datasource.LeagueDataSource
import com.lan.sanbercodefinalproject.ui.shared.NoResultsUI
import com.lan.sanbercodefinalproject.ui.shared.ShowProgressIndicator
import com.lan.sanbercodefinalproject.ui.shared.TabLayout
import com.lan.sanbercodefinalproject.ui.shared.navigations.MenuNavigationTopUI
import com.lan.sanbercodefinalproject.ui.theme.SanbercodeFinalProjectTheme
import com.lan.sanbercodefinalproject.viewmodel.TabLayoutViewModel
import com.lan.sanbercodefinalproject.viewmodel.TeamsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeamsScreenUI(teamViewModel: TeamsViewModel, tabLayoutViewModel: TabLayoutViewModel, activity: BaseActivity, navController: NavController? = null) {
    val teamItems by teamViewModel.teamItems.observeAsState(emptyList())
    val onProcess by teamViewModel.onProgress.observeAsState(false)
    val tabIndex by tabLayoutViewModel.tabIndex.observeAsState(0)
    
    tabLayoutViewModel.tabs.clear()
    for (league in LeagueDataSource.loadLeagues()) {
        tabLayoutViewModel.tabs.add(Pair("" + league.leagueKey, "" + league.leagueName))
    }

    LaunchedEffect(Unit) {
        teamViewModel.fetchTeams(tabLayoutViewModel.tabs[tabIndex].first)
    }

    Scaffold(
        topBar = { MenuNavigationTopUI(activity = activity, title = "Teams", navController = navController) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            TabLayout(viewModel = tabLayoutViewModel) {
                Log.i("TeamScreenUI", "TabLayout.index: $it")
//                teamViewModel.fetchTeams(it)

                if (teamItems.isNotEmpty()) {
                    LazyColumn(modifier = Modifier.wrapContentHeight()) {
                        items(teamItems) { team ->
                            if (team.teamKey?.isNotEmpty() == true) {
                                TeamCardUI(data = team) {
                                    Intent(activity, PlayersActivity::class.java).also { intent ->
                                        intent.putExtra(PlayersActivity.EXTRA_PLAYER_DATA, Gson().toJson(it))
                                        activity.startActivity(intent)
                                    }
                                }
                            }
                            else {
                                Box(modifier = Modifier.padding(32.dp)) { NoResultsUI("No teams registered") }
                            }
                        }
                    }
                }
            }
        }

        ShowProgressIndicator(onProcess)
    }
}

@Preview
@Composable
private fun Preview() {
    SanbercodeFinalProjectTheme {
        TeamsScreenUI(TeamsViewModel(), TabLayoutViewModel(), MainActivity::class.java.newInstance())
    }
}
