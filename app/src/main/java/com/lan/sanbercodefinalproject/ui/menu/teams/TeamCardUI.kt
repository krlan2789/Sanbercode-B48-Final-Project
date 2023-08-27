package com.lan.sanbercodefinalproject.ui.menu.teams

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.lan.sanbercodefinalproject.model.response.ResultArticlesItem
import com.lan.sanbercodefinalproject.model.response.ResultTeamItem
import com.lan.sanbercodefinalproject.ui.theme.SanbercodeFinalProjectTheme

@Composable
fun TeamCardUI(data: ResultTeamItem, modifier: Modifier = Modifier, onClick: ((ResultTeamItem) -> Unit)? = null) {
    val height = 112
    Card(
        modifier = modifier
            .height(height.dp)
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp)
            .clickable(onClick = {
                Log.i("TeamsCardUI", "TeamsCard.click: " + data.teamName)
                onClick?.invoke(data)
            })
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(top = 12.dp, bottom = 12.dp, start = 16.dp, end = 16.dp)
        ) {
            AsyncImage(
                model = data.teamLogo,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = "Team ID " + data.teamKey,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .height(15.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    color = Color.Gray,
                    fontSize = 13.sp,
                    maxLines = 1
                )
                Text(
                    text = "" + data.teamName,
                    modifier = Modifier
                        .padding(start = 8.dp, top = 4.dp, bottom = 4.dp)
                        .wrapContentHeight()
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.headlineSmall,
                    lineHeight = 1.3.em,
                    fontSize = 18.sp
                )
                Text(
                    text = "${data.players?.count()} players",
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .height(15.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    color = Color.Gray,
                    fontSize = 13.sp,
                    maxLines = 1
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    SanbercodeFinalProjectTheme {
        TeamCardUI(data = ResultTeamItem())
    }
}