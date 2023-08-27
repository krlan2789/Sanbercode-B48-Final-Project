package com.lan.sanbercodefinalproject.ui.menu.home

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.gson.Gson
import com.lan.sanbercodefinalproject.activity.MainActivity
import com.lan.sanbercodefinalproject.activity.DetailActivity
import com.lan.sanbercodefinalproject.ui.menu.articles.ArticleCardUI
import com.lan.sanbercodefinalproject.ui.shared.ContentListUI
import com.lan.sanbercodefinalproject.ui.shared.SearchInputFieldUI
import com.lan.sanbercodefinalproject.ui.shared.ShowProgressIndicator
import com.lan.sanbercodefinalproject.ui.theme.SanbercodeFinalProjectTheme
import com.lan.sanbercodefinalproject.viewmodel.ArticlesViewModel

@Composable
fun HomeScreenUI(viewModel: ArticlesViewModel, activity: ComponentActivity) {
    val articles by viewModel.articles.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchArticles()
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Box(modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)) {
            SearchInputFieldUI(modifier = Modifier.fillMaxWidth())
        }

        ContentListUI(articles) {article ->
            ArticleCardUI(data = article) {
                Intent(activity, DetailActivity::class.java).also {intent ->
                    intent.putExtra(DetailActivity.EXTRA_DETAIL_DATA, Gson().toJson(it))
                    intent.putExtra(DetailActivity.EXTRA_DETAIL_TYPE, DetailActivity.DETAIL_ARTICLE)
                    activity.startActivity(intent)
                }
            }
        }
    }
    ShowProgressIndicator(articles.isEmpty())
}

@Preview
@Composable
private fun Preview() {
    SanbercodeFinalProjectTheme {
        HomeScreenUI(ArticlesViewModel(), MainActivity::class.java.newInstance())
    }
}
