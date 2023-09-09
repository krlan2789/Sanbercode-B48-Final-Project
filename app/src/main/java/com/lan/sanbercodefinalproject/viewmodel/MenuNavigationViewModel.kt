package com.lan.sanbercodefinalproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lan.sanbercodefinalproject.datasource.MenuNavStack
import java.util.Stack

class MenuNavigationViewModel : ViewModel() {
    private var _currentMenuNav = MutableLiveData<Pair<String, String>?>()
    val currentMenuNav = _currentMenuNav

    fun setMenuNav(item: Pair<String, String>?) {
        _currentMenuNav.value = item
    }
}