package com.lan.sanbercodefinalproject.ui.shared.navigations

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.lan.sanbercodefinalproject.R
import com.lan.sanbercodefinalproject.ui.theme.SanbercodeFinalProjectTheme

@Composable
fun MenuNavigationTopUI(height: Int = 56, activity: ComponentActivity = ComponentActivity()) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(height.dp)
            .background(color = MaterialTheme.colorScheme.primary)
            .padding(4.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_keyboard_backspace_24),
            contentDescription = "",
            tint = MaterialTheme.colorScheme.primaryContainer,
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
                .clickable { activity.finish() }
        )
    }
}

@Preview
@Composable
private fun Preview() {
    SanbercodeFinalProjectTheme {
        MenuNavigationTopUI()
    }
}
