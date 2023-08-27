package com.lan.sanbercodefinalproject.ui.menu.teams

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.gson.Gson
import com.lan.sanbercodefinalproject.activity.MainActivity
import com.lan.sanbercodefinalproject.activity.PlayersActivity
import com.lan.sanbercodefinalproject.datasource.LeagueDataSource
import com.lan.sanbercodefinalproject.ui.shared.ContentListUI
import com.lan.sanbercodefinalproject.ui.shared.NoResultsUI
import com.lan.sanbercodefinalproject.ui.shared.ShowProgressIndicator
import com.lan.sanbercodefinalproject.ui.shared.navigations.MenuNavigationTopUI
import com.lan.sanbercodefinalproject.ui.theme.SanbercodeFinalProjectTheme
import com.lan.sanbercodefinalproject.viewmodel.TeamsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeamsScreenUI(viewModel: TeamsViewModel, activity: ComponentActivity) {
    val teams by viewModel.teamItems.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchTeams(LeagueDataSource.loadLeagues()[0])
    }

    Scaffold(
        topBar = { MenuNavigationTopUI(activity = activity, title = "Teams") }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            ContentListUI(contentItems = teams) { team ->
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

        ShowProgressIndicator(teams.isEmpty())
    }
}

@Preview
@Composable
private fun Preview() {
    SanbercodeFinalProjectTheme {
        TeamsScreenUI(TeamsViewModel(), MainActivity::class.java.newInstance())
    }
}
