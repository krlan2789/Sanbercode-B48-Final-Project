package com.lan.sanbercodefinalproject.ui.menu.details

import android.content.Intent
import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.lan.sanbercodefinalproject.activity.MainActivity
import com.lan.sanbercodefinalproject.model.response.ResultArticlesItem
import com.lan.sanbercodefinalproject.ui.theme.SanbercodeFinalProjectTheme
import com.lan.sanbercodefinalproject.viewmodel.DetailViewModel

@Composable
fun ArticleDetailScreenUI(data: ResultArticlesItem, activity: ComponentActivity) {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = data.urlToImage,
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(3f / 2f)
                .padding(bottom = 16.dp),
            contentScale = ContentScale.Crop
        )

        Text(
            text = "" + data.title,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp),
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Justify,
            fontSize = 24.sp
        )

        Text(
            text = "${data.description}\n\n${("" + data.content).replaceAfter("… [+", "").replace("… [+", "")}....",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp),
            textAlign = TextAlign.Start,
            fontSize = 18.sp
        )

        Text(
            text = "Written by " + data.author,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 16.dp),
            style = MaterialTheme.typography.titleLarge,
            color = Color.DarkGray,
            fontSize = 15.sp,
            maxLines = 1
        )

        Text(
            text = "Published at " + ("" + data.publishedAt).uppercase().replaceAfter("T", "").replace("T", ""),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp),
            color = Color.DarkGray,
            fontSize = 12.sp,
            maxLines = 1
        )

        Text(
            text = "Continue reading",
            modifier = Modifier
                .wrapContentSize()
                .padding(vertical = 32.dp, horizontal = 16.dp)
                .clickable
                {
                    if (data.url?.isEmpty() == true) return@clickable
                    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(data.url))
                    activity.startActivity(browserIntent)
                },
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            fontSize = 15.sp,
            maxLines = 1
        )
    }
}

@Preview
@Composable
private fun Preview() {
    SanbercodeFinalProjectTheme {
        ArticleDetailScreenUI(ResultArticlesItem(title = "Lorem ipsum dolor sit amet", publishedAt = "2023-08-25"), MainActivity::class.java.newInstance())
    }
}
