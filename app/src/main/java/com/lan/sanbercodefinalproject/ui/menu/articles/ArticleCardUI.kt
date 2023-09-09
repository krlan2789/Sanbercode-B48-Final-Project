package com.lan.sanbercodefinalproject.ui.menu.articles

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
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
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.lan.sanbercodefinalproject.model.response.ResultArticlesItem
import com.lan.sanbercodefinalproject.ui.theme.SanbercodeFinalProjectTheme
import java.util.Locale

@Composable
fun ArticleCardUI(data: ResultArticlesItem, modifier: Modifier = Modifier, onClick: ((ResultArticlesItem) -> Unit)? = null) {
    val datePublished = ("" + data.publishedAt).uppercase(Locale.ROOT)

    Card(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp)
            .clickable(onClick = {
                Log.i("ArticleCardUI", "ArticleCard.click: " + data.title)
                onClick?.invoke(data)
            })
    ) {
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = data.urlToImage,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(3f / 2f)
                    .padding(bottom = 8.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "" + data.title,
                modifier = Modifier
                    .padding(vertical = 4.dp, horizontal = 16.dp)
                    .wrapContentHeight()
                    .fillMaxWidth(),
                style = MaterialTheme.typography.headlineSmall,
                maxLines = 1,
                fontSize = 17.sp
            )
            Text(
                text = "" + data.description,
                modifier = Modifier
                    .padding(vertical = 4.dp, horizontal = 16.dp)
                    .wrapContentHeight()
                    .fillMaxWidth(),
                textAlign = TextAlign.Start,
                fontSize = 14.sp,
                maxLines = 1
            )
            Text(
                text = datePublished.replaceAfter("T", "").replace("T", ""),
                modifier = Modifier
                    .padding(top = 4.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
                    .wrapContentHeight()
                    .fillMaxWidth(),
                textAlign = TextAlign.End,
                color = Color.DarkGray,
                fontSize = 12.sp,
                maxLines = 1
            )
        }
    }

//    Spacer(modifier = Modifier.height(16.dp).fillMaxWidth())
}

@Preview
@Composable
private fun Preview() {
    SanbercodeFinalProjectTheme {
        ArticleCardUI(ResultArticlesItem())
    }
}