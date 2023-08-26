package com.lan.sanbercodefinalproject.ui.shared

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lan.sanbercodefinalproject.ui.theme.SanbercodeFinalProjectTheme

@Composable
fun ButtonGroupUI(items: Map<String, () -> Unit>, modifier: Modifier = Modifier) {
    var selectedOption by remember { mutableStateOf("") }
    val onSelectionChange = { text: String -> selectedOption = text }

    Row(modifier = modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(8.dp))
        .background(MaterialTheme.colorScheme.primaryContainer)
    ) {
        for (item in items) {
            if (selectedOption == "") selectedOption = item.key
            Box(
                contentAlignment = Center,
                modifier = Modifier
                    .height(32.dp)
                    .align(CenterVertically)
                    .weight(1f)
                    .clickable {
                        onSelectionChange(item.key)
                        item.value()
                    }
                    .clip(RoundedCornerShape(8.dp))
                    .background(
                        if (selectedOption == item.key) MaterialTheme.colorScheme.primary
                        else MaterialTheme.colorScheme.primaryContainer
                    )
            ) {
                Text(
                    text = item.key,
                    color = (
                        if (selectedOption != item.key) MaterialTheme.colorScheme.primary
                        else MaterialTheme.colorScheme.primaryContainer
                    )
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    SanbercodeFinalProjectTheme {
        ButtonGroupUI(mutableMapOf(
            "News" to { Log.i("ButtonGroupUI", "News.clicked") },
            "Matches" to { Log.i("ButtonGroupUI", "Matches.clicked") }
        ))
    }
}