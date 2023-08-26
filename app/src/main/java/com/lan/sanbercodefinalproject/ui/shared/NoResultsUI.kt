package com.lan.sanbercodefinalproject.ui.shared

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lan.sanbercodefinalproject.ui.theme.SanbercodeFinalProjectTheme

@Composable
fun NoResultsUI(message: String = "No results found") {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        Text(message)
    }
}

@Preview
@Composable
private fun Preview() {
    SanbercodeFinalProjectTheme {
        NoResultsUI()
    }
}