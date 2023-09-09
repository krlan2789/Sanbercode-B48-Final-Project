package com.lan.sanbercodefinalproject.ui.shared.navigations

import androidx.activity.compose.BackHandler
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
import com.lan.sanbercodefinalproject.datasource.MenuNavStack
import com.lan.sanbercodefinalproject.model.MenuNavigationItemModel
import com.lan.sanbercodefinalproject.ui.theme.SanbercodeFinalProjectTheme
import com.lan.sanbercodefinalproject.viewmodel.MenuNavigationViewModel

@Composable
fun MenuNavigationBottomUI(
    navController: NavController = rememberNavController(),
    viewModel: MenuNavigationViewModel
) {
    val bottomNavItems = listOf(
        MenuNavigationItemModel.Home,
        MenuNavigationItemModel.Leagues,
        MenuNavigationItemModel.Teams,
        MenuNavigationItemModel.Players,
    )

    val selectedItem by viewModel.currentMenuNav.observeAsState(bottomNavItems[0].getPair())

    BackHandler(enabled = true) {
        MenuNavStack.previous(navController = navController, viewModel = viewModel)
    }

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primary,
        modifier = Modifier.height(64.dp)
    ) {
        bottomNavItems.forEach { item ->
            NavigationBarItem(
                selected = selectedItem?.first == item.route,
                onClick = {
                    val pairTarget = item.getPair()
                    MenuNavStack.next(navController = navController, viewModel = viewModel, target = pairTarget)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = "${item.title} Icon",
                        tint = (if (selectedItem?.first == item.route) MaterialTheme.colorScheme.primary; else MaterialTheme.colorScheme.primaryContainer),
                        modifier = Modifier
                            .height((if (selectedItem?.first == item.route) 32; else 28).dp)
                            .aspectRatio(1f)
                            .padding(bottom = (if (selectedItem?.first == item.route) 0; else 12).dp)
                    )
                },
                label = {
                    if (selectedItem?.first != item.route) {
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
