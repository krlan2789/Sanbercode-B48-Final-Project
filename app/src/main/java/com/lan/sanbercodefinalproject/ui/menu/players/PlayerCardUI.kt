package com.lan.sanbercodefinalproject.ui.menu.players

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.lan.sanbercodefinalproject.model.response.PlayersItem
import com.lan.sanbercodefinalproject.ui.theme.SanbercodeFinalProjectTheme

@Composable
fun PlayerCardUI(data: PlayersItem, modifier: Modifier = Modifier, height: Int = 112, onClick: ((PlayersItem) -> Unit)? = null) {
    Card(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp)
            .clickable(onClick = {
                Log.i("PlayerCardUI", "PlayerCard.click: ${data.playerName} | ${data.playerImage}")
                onClick?.invoke(data)
            })
    ) {
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            if (data.playerImage?.isNotEmpty() == true) {
                AsyncImage(
                    model = data.playerImage,
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxHeight()
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            Text(
                text = "" + data.playerName,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .wrapContentHeight()
                    .fillMaxWidth(),
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Text(
                text = "${data.playerAge} years old",
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                color = Color.Gray,
                fontSize = 13.sp
            )
            Text(
                text = "Nationality " + data.playerCountry,
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                color = Color.Gray,
                fontSize = 13.sp
            )
            Text(
                text = "" + data.playerType,
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                color = Color.Gray,
                fontSize = 13.sp
            )
            Text(
                text = "Number ${data.playerNumber}",
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                color = Color.Gray,
                fontSize = 13.sp,
            )
            Text(
                text = "${data.playerGoals} goals",
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                color = Color.Gray,
                fontSize = 13.sp,
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    SanbercodeFinalProjectTheme {
        PlayerCardUI(data = PlayersItem(
            playerAge = "25", playerGoals = "80", playerName = "Erlan Kurnia", playerNumber = "8", playerType = "Center Midfielder", playerCountry = "Indonesia", playerKey = 1
        ))
    }
}