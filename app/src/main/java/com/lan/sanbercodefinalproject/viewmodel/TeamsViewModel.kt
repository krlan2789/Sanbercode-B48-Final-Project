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
    private val _teamItems = MutableLiveData<List<ResultTeamItem>>()
    val teamItems: LiveData<List<ResultTeamItem>> = _teamItems

    fun fetchTeams(league: ResultLeagueItem) {
        viewModelScope.launch {
            try {
                FootballConfigAPI.teamsService.getTeams("" + league.leagueKey).enqueue(object : Callback<ResponseTeams> {
                    override fun onResponse(call: Call<ResponseTeams>, response: Response<ResponseTeams>) {
                        Log.i("TeamsViewModel.onResponse", response.message())
                        if (response.isSuccessful) {
                            Log.i("TeamsViewModel", response.body()!!.toString())
                            if (response.body() != null) _teamItems.value = response.body()!!.result
                        }
                    }

                    override fun onFailure(call: Call<ResponseTeams>, t: Throwable) {
                        Log.w("TeamsViewModel.onFailure", "Data not Found")
                    }
                })
            } catch (e: Exception) {
                Log.e("TeamsViewModel", "TeamsViewModel.fetchTeams: " + e.message)
            }
        }
    }
}