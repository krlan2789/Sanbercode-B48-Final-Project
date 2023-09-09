package com.lan.sanbercodefinalproject.datasource

import android.util.Log
import androidx.navigation.NavController
import com.lan.sanbercodefinalproject.model.MenuNavigationItemModel
import com.lan.sanbercodefinalproject.viewmodel.MenuNavigationViewModel
import java.util.Stack

object MenuNavStack {
    private val previous = Stack<Pair<String, String>>()

    private fun push(item: Pair<String, String>?) {
        if (item == null) return

        if (item.first == MenuNavigationItemModel.Home.route) {
            previous.clear()
        } else {
            if (previous.isNotEmpty()) {
                var hasPrevious = false
                for (p in previous) {
                    if (p.first == item.first) {
                        hasPrevious = true
                        break
                    }
                }
                if (!hasPrevious) previous.push(item)
            }
        }
    }

    private fun pop() : Pair<String, String>? {
        return when(previous.isNotEmpty()) {
            true -> previous.pop()
            false -> null
        }
    }

    fun next(navController: NavController, target: Pair<String, String>?, viewModel: MenuNavigationViewModel) {
        if (target != null) {
            viewModel.setMenuNav(target)
            Log.i("MenuNavStack", "next.item: ${target.first}")
            onChangeRoute(navController = navController, viewModel = viewModel, target = target)
        }
    }

    fun previous(navController: NavController, viewModel: MenuNavigationViewModel) {
        val target = pop()
        if (target != null) {
            viewModel.setMenuNav(target)
            Log.i("MenuNavStack", "previous.item: ${target.first}")
            onChangeRoute(navController = navController, viewModel = viewModel, target = target)
        }
    }

    private fun onChangeRoute(navController: NavController, viewModel: MenuNavigationViewModel? = null, target: Pair<String, String>? = null) {
        for (i in previous) {
            Log.i("MenuNavStack.previous", "Previous.item::${i.first}")
        }
        if (target != null) {
            Log.i("NavigationItem", "${target.first}::${target.second}")
            navController.navigate(target.first) {
                navController.graph.startDestinationRoute?.let { route ->
                    popUpTo(route) {
                        saveState = true
                    }
                }
            }
        }
    }
}
