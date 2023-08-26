package com.lan.sanbercodefinalproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailViewModel : ViewModel() {
    val currentData = MutableLiveData<String>()
    val currentType = MutableLiveData<String>()

    fun setData(json: String, type: String) {
        currentData.value = json
        currentType.value = type
    }
}
