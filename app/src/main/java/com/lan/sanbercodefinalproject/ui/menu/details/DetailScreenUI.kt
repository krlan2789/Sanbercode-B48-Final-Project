package com.lan.sanbercodefinalproject.ui.menu.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.gson.Gson
import com.lan.sanbercodefinalproject.activity.DetailActivity
import com.lan.sanbercodefinalproject.model.response.ResultArticlesItem
import com.lan.sanbercodefinalproject.ui.theme.SanbercodeFinalProjectTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreenUI(data: String, type: String, activity: DetailActivity) {
    Scaffold(
        topBar = {}
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxWidth().
            wrapContentHeight(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if (data.isNotEmpty()) {
                when (type) {
                    DetailActivity.DETAIL_ARTICLE -> {
                        ArticleDetailScreenUI(
                            Gson().fromJson(
                                data,
                                ResultArticlesItem::class.java
                            ),
                            activity = activity
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    SanbercodeFinalProjectTheme {
        DetailScreenUI("{}", "DETAIL_ARTICLE", DetailActivity::class.java.newInstance())
    }
}
