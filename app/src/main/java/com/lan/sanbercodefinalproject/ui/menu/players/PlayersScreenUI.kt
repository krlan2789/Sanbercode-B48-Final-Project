package com.lan.sanbercodefinalproject.ui.menu.players

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.lan.sanbercodefinalproject.activity.PlayersActivity
import com.lan.sanbercodefinalproject.model.response.PlayersItem
import com.lan.sanbercodefinalproject.model.response.ResultTeamItem
import com.lan.sanbercodefinalproject.ui.shared.ContentListUI
import com.lan.sanbercodefinalproject.ui.shared.NoResultsUI
import com.lan.sanbercodefinalproject.ui.shared.navigations.MenuNavigationTopUI
import com.lan.sanbercodefinalproject.ui.theme.SanbercodeFinalProjectTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayersScreenUI(data: ResultTeamItem, activity: ComponentActivity) {
    val navController = rememberNavController()

    Scaffold(
        topBar = { MenuNavigationTopUI(activity = activity, title = "My Favorite Players") }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            ContentListUI(contentItems = data.players) { player ->
                if (player.playerKey!! > 0) {
                    PlayerCardUI(data = player)
                } else {
                    Box(modifier = Modifier.padding(32.dp)) { NoResultsUI("No player registered") }
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    SanbercodeFinalProjectTheme {
        PlayersScreenUI(ResultTeamItem(players = listOf(
            PlayersItem(playerAge = "25", playerGoals = "80", playerName = "Erlan Kurnia", playerNumber = "8", playerType = "Center Midfielder", playerCountry = "Indonesia", playerKey = 1)
        )), PlayersActivity::class.java.newInstance())
    }
}
