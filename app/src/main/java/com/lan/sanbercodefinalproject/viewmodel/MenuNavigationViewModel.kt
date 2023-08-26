package com.lan.sanbercodefinalproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MenuNavigationViewModel : ViewModel() {
    var currentMenu = MutableLiveData<Int>()

    fun setCurrentMenu(index: Int) {
        currentMenu.value = index
    }
}