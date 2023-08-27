package com.lan.sanbercodefinalproject.ui.shared.navigations

import android.util.Log
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.lan.sanbercodefinalproject.model.MenuNavigationItemModel
import com.lan.sanbercodefinalproject.ui.theme.SanbercodeFinalProjectTheme
import com.lan.sanbercodefinalproject.viewmodel.MenuNavigationViewModel

@Composable
fun MenuNavigationBottomUI(
    navController: NavController = rememberNavController(),
    viewModel: MenuNavigationViewModel? = null
) {
    val bottomNavItems = listOf(
        MenuNavigationItemModel.Home,
        MenuNavigationItemModel.Teams,
        MenuNavigationItemModel.Leagues,
        MenuNavigationItemModel.Players,
    )
    val selectedItem by viewModel!!.currentMenu.observeAsState(0)

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primary,
        modifier = Modifier.height(64.dp)
    ) {
        bottomNavItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {
                    viewModel?.setCurrentMenu(index)
                    Log.i("NavigationItem", "${index}::${item.title}")
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = "${item.title} Icon",
                        tint = (
                            if (selectedItem == index) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.primaryContainer
                        ),
                        modifier = Modifier.height((
                            if (selectedItem == index) 32
                            else 28
                        ).dp).aspectRatio(1f).padding(bottom = (
                            if (selectedItem == index) 0
                            else 12
                        ).dp)
                    )
                },
                label = {
                    if (selectedItem != index) {
                        Text(
                            text = item.title,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.primaryContainer,
                        )
                    }
                },
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    SanbercodeFinalProjectTheme {
        MenuNavigationBottomUI(viewModel = MenuNavigationViewModel())
    }
}
