package com.lan.sanbercodefinalproject.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.disk.DiskCache
import com.lan.sanbercodefinalproject.ui.shared.navigations.MenuNavigationBottomUI
import com.lan.sanbercodefinalproject.ui.shared.navigations.MenuNavigationUI
import com.lan.sanbercodefinalproject.ui.theme.SanbercodeFinalProjectTheme
import com.lan.sanbercodefinalproject.viewmodel.ArticlesViewModel
import com.lan.sanbercodefinalproject.viewmodel.LeaguesViewModel
import com.lan.sanbercodefinalproject.viewmodel.MenuNavigationViewModel
import com.lan.sanbercodefinalproject.viewmodel.TeamsViewModel

class MainActivity : ComponentActivity(), ImageLoaderFactory {
    private val articlesViewModel: ArticlesViewModel by viewModels()
    private val teamsViewModel: TeamsViewModel by viewModels()
    private val leaguesViewModel: LeaguesViewModel by viewModels()
    private val navigationViewModel: MenuNavigationViewModel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            SanbercodeFinalProjectTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Scaffold(bottomBar = {
                        MenuNavigationBottomUI(navController, navigationViewModel)
                    }) {
                        padding ->
                        Column(
                            modifier = Modifier
                                .padding(padding)
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            MenuNavigationUI(navController, this@MainActivity, articlesViewModel, teamsViewModel, leaguesViewModel)
                        }
                    }
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
