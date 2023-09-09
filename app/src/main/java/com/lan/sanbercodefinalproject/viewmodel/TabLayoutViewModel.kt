package com.lan.sanbercodefinalproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TabLayoutViewModel : ViewModel() {
    private val _tabIndex: MutableLiveData<Int> = MutableLiveData(0)
    val tabIndex: LiveData<Int> = _tabIndex
    var tabs = mutableListOf<Pair<String, String>>(
        Pair("1", "Premier League"),
        Pair("2", "Serie A"),
        Pair("3", "LaLiga"),
    )

    fun updateTabIndexBasedOnSwipe(isSwipeToTheLeft: Boolean) {
        _tabIndex.value = when (isSwipeToTheLeft) {
            true -> Math.floorMod(_tabIndex.value!!.plus(1), tabs.size)
            false -> Math.floorMod(_tabIndex.value!!.minus(1), tabs.size)
        }
    }

    fun updateTabIndex(i: Int) {
        _tabIndex.value = i
    }
}