package com.lan.sanbercodefinalproject.ui.menu.teams

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lan.sanbercodefinalproject.activity.MainActivity
import com.lan.sanbercodefinalproject.datasource.LeagueDataSource
import com.lan.sanbercodefinalproject.ui.shared.ContentListUI
import com.lan.sanbercodefinalproject.ui.shared.NoResultsUI
import com.lan.sanbercodefinalproject.ui.shared.ShowProgressIndicator
import com.lan.sanbercodefinalproject.ui.shared.teams.TeamCardUI
import com.lan.sanbercodefinalproject.ui.theme.SanbercodeFinalProjectTheme
import com.lan.sanbercodefinalproject.viewmodel.TeamsViewModel

@Composable
fun TeamsScreenUI(viewModel: TeamsViewModel, activity: ComponentActivity) {
    val teams by viewModel.teamItems.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchTeams(LeagueDataSource.loadLeagues()[0])
    }

    ShowProgressIndicator(teams.isEmpty())
    ContentListUI(contentItems = teams) { team ->
        if (team.teamKey?.isNotEmpty() == true) {
            TeamCardUI(data = team)
        }
        else {
            Box(modifier = Modifier.padding(32.dp)) { NoResultsUI("No teams registered") }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    SanbercodeFinalProjectTheme {
        TeamsScreenUI(TeamsViewModel(), MainActivity::class.java.newInstance())
    }
}
