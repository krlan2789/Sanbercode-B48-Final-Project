package com.lan.sanbercodefinalproject.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lan.sanbercodefinalproject.api.config.FootballConfigAPI
import com.lan.sanbercodefinalproject.model.response.ResponseTeams
import com.lan.sanbercodefinalproject.model.response.ResultLeagueItem
import com.lan.sanbercodefinalproject.model.response.ResultTeamItem
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamsViewModel : ViewModel() {
    private val _teamItems: MutableLiveData<List<ResultTeamItem>> = MutableLiveData()
    val teamItems: LiveData<List<ResultTeamItem>> = _teamItems

    private var _onProgress = MutableLiveData(false)
    val onProgress: LiveData<Boolean> = _onProgress

    fun fetchTeams(league: ResultLeagueItem) {
        fetchTeams("" + league.leagueKey)
    }

    fun fetchTeams(leagueKey: String) {
        Log.i("TeamsViewModel.fetchTeams", "LeagueKey: $leagueKey")
        if (_onProgress.value == true) return
        _onProgress.value = true
        _teamItems.value = emptyList()
        viewModelScope.launch {
            try {
                FootballConfigAPI.teamsService.getTeams("" + leagueKey).enqueue(object : Callback<ResponseTeams> {
                    override fun onResponse(call: Call<ResponseTeams>, response: Response<ResponseTeams>) {
                        Log.i("TeamsViewModel.onResponse", response.message())
                        if (response.isSuccessful) {
                            Log.i("TeamsViewModel.body", "$leagueKey : ${response.body()!!.toString()}")
                            if (response.body() != null) _teamItems.value = response.body()!!.result
                        }
                        _onProgress.value = false
                    }

                    override fun onFailure(call: Call<ResponseTeams>, t: Throwable) {
                        Log.w("TeamsViewModel.onFailure", "Data not Found")
                        _onProgress.value = false
                    }
                })
            } catch (e: Exception) {
                Log.e("TeamsViewModel", "TeamsViewModel.fetchTeams: " + e.message)
                _onProgress.value = false
            }
        }
    }
}