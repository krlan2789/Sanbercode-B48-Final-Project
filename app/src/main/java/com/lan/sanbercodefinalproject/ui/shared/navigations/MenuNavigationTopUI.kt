package com.lan.sanbercodefinalproject.ui.shared.navigations

import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.lan.sanbercodefinalproject.R
import com.lan.sanbercodefinalproject.ui.theme.SanbercodeFinalProjectTheme

@Composable
fun MenuNavigationTopUI(activity: ComponentActivity = ComponentActivity(), navController: NavController? = null, title: String = "", height: Int = 56) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(height.dp)
        .background(color = MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Center),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.primaryContainer
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(height.dp)
            .padding(4.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_keyboard_backspace_24),
            contentDescription = "",
            tint = MaterialTheme.colorScheme.primaryContainer,
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
                .clickable {
//                    if (navController != null) {
//                        val route = "" + navController.previousBackStackEntry?.destination?.route
//                        if (route.isNotEmpty()) {
//                            Log.i("MenuNavigationTopUI", "onBackButton.click: $route")
//                            navController.navigate(route) {
//                                navController.graph.startDestinationRoute?.let { route ->
//                                    popUpTo(route) {
//                                        saveState = true
//                                    }
//                                }
//                            }
//                            navController.popBackStack()
//                        } else
//                            activity.finish()
//                    } else
                        activity.finish()
                }
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
