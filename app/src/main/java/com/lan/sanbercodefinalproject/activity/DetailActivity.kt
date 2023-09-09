package com.lan.sanbercodefinalproject.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.disk.DiskCache
import com.lan.sanbercodefinalproject.activity.ui.theme.SanbercodeFinalProjectTheme
import com.lan.sanbercodefinalproject.ui.menu.details.DetailScreenUI

class DetailActivity : BaseActivity(), ImageLoaderFactory {
    companion object {
        const val EXTRA_DETAIL_DATA = "EXTRA_DETAIL_DATA"
        const val EXTRA_DETAIL_TYPE = "EXTRA_DETAIL_TYPE"

        const val DETAIL_ARTICLE = "DETAIL_ARTICLE"
        const val DETAIL_TEAM = "DETAIL_TEAM"
        const val DETAIL_PLAYER = "DETAIL_PLAYER"
        const val DETAIL_LEAGUE = "DETAIL_LEAGUE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val currentData = "" + intent.getStringExtra(EXTRA_DETAIL_DATA)
        val currentType = "" + intent.getStringExtra(EXTRA_DETAIL_TYPE)

        setContent {
            SanbercodeFinalProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DetailScreenUI(currentData, currentType, this@DetailActivity)
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
