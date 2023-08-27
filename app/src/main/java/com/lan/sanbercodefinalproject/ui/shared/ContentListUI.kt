package com.lan.sanbercodefinalproject.ui.shared

import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lan.sanbercodefinalproject.model.response.ResultTeamItem
import com.lan.sanbercodefinalproject.ui.menu.teams.TeamCardUI
import com.lan.sanbercodefinalproject.ui.theme.SanbercodeFinalProjectTheme

@Composable
fun <T> ContentListUI(contentItems: List<T>, modifier: Modifier = Modifier, template: @Composable() (LazyItemScope.(T) -> Unit)) {
    LazyColumn(modifier = modifier.wrapContentHeight()) {
        items(contentItems) {
            template(it)
        }
    }
}

@Preview
@Composable
private fun Preview() {
    SanbercodeFinalProjectTheme {
        ContentListUI(contentItems = listOf<ResultTeamItem>(
            ResultTeamItem(players = listOf(), teamKey = "123", teamLogo = "", teamName = "Chelsea"),
            ResultTeamItem(players = listOf(), teamKey = "123", teamLogo = "", teamName = "Chelsea"),
            ResultTeamItem(players = listOf(), teamKey = "123", teamLogo = "", teamName = "Chelsea"),
            ResultTeamItem(players = listOf(), teamKey = "123", teamLogo = "", teamName = "Chelsea"),
            ResultTeamItem(players = listOf(), teamKey = "123", teamLogo = "", teamName = "Chelsea"),
            ResultTeamItem(players = listOf(), teamKey = "123", teamLogo = "", teamName = "Chelsea"),
            ResultTeamItem(players = listOf(), teamKey = "123", teamLogo = "", teamName = "Chelsea"),
        )) { team ->
            TeamCardUI(data = team)
        }
    }
}