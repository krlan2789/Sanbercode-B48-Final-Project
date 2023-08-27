package com.lan.sanbercodefinalproject.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.disk.DiskCache
import com.google.gson.Gson
import com.lan.sanbercodefinalproject.activity.ui.theme.SanbercodeFinalProjectTheme
import com.lan.sanbercodefinalproject.model.response.ResultArticlesItem
import com.lan.sanbercodefinalproject.model.response.ResultTeamItem
import com.lan.sanbercodefinalproject.ui.menu.players.PlayersScreenUI

class PlayersActivity : ComponentActivity(), ImageLoaderFactory {
    companion object {
        const val EXTRA_PLAYER_DATA = "EXTRA_PLAYER_DATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val teamData = "" + intent.getStringExtra(EXTRA_PLAYER_DATA)

        setContent {
            SanbercodeFinalProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PlayersScreenUI(
                        Gson().fromJson(
                        teamData,
                        ResultTeamItem::class.java
                    ), this)
                }
            }
        }
    }

    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this)
            .diskCache {
                DiskCache.Builder()
                    .directory(this.cacheDir.resolve("image_cache"))
                    .maxSizePercent(0.05)
                    .build()
            }
            .build()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SanbercodeFinalProjectTheme {
        PlayersScreenUI(ResultTeamItem(), PlayersActivity::class.java.newInstance())
    }
}