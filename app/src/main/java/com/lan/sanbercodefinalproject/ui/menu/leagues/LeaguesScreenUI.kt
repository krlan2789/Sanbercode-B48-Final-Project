package com.lan.sanbercodefinalproject.ui.menu.leagues

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lan.sanbercodefinalproject.activity.MainActivity
import com.lan.sanbercodefinalproject.datasource.LeagueDataSource
import com.lan.sanbercodefinalproject.ui.shared.ContentListUI
import com.lan.sanbercodefinalproject.ui.shared.NoResultsUI
import com.lan.sanbercodefinalproject.ui.shared.ShowProgressIndicator
import com.lan.sanbercodefinalproject.ui.shared.leagues.LeagueCardUI
import com.lan.sanbercodefinalproject.ui.theme.SanbercodeFinalProjectTheme
import com.lan.sanbercodefinalproject.viewmodel.LeaguesViewModel

@Composable
fun LeaguesScreenUI(viewModel: LeaguesViewModel, activity: ComponentActivity) {
    val leagues by viewModel.leagues.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchTeams()
    }

    ShowProgressIndicator(leagues.isEmpty())
    ContentListUI(contentItems = leagues) { league ->
        if (league.leagueKey?.isNotEmpty() == true) {
            LeagueCardUI(data = league)
        }
        else {
            Box(modifier = Modifier.padding(32.dp)) { NoResultsUI("No leagues registered") }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    SanbercodeFinalProjectTheme {
        LeaguesScreenUI(LeaguesViewModel(), MainActivity::class.java.newInstance())
    }
}
