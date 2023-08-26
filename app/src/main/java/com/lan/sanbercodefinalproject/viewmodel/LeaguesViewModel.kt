package com.lan.sanbercodefinalproject.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lan.sanbercodefinalproject.datasource.LeagueDataSource
import com.lan.sanbercodefinalproject.model.response.ResultLeagueItem
import kotlinx.coroutines.launch

class LeaguesViewModel : ViewModel() {
    private val _leagues = MutableLiveData<List<ResultLeagueItem>>()
    val leagues: LiveData<List<ResultLeagueItem>> = _leagues

    fun fetchTeams(league: ResultLeagueItem? = null) {
        viewModelScope.launch {
            try {
                if (league == null) _leagues.value = LeagueDataSource.loadLeagues()
                else {
                    val selectedLeague = LeagueDataSource.loadLeague(league.leagueKey)
                    _leagues.value = listOf(selectedLeague ?: ResultLeagueItem())
                }
            } catch (e: Exception) {
                Log.e("TeamsViewModel", "TeamsViewModel.fetchTeams: " + e.message)
            }
        }
    }
}