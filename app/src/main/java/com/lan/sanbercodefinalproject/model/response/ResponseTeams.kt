package com.lan.sanbercodefinalproject.model.response

import com.google.gson.annotations.SerializedName

data class ResponseTeams(

	@field:SerializedName("result")
	val result: List<ResultTeamItem> = listOf(),

	@field:SerializedName("success")
	val success: Int = 0
)

data class ResultTeamItem(

	@field:SerializedName("players")
	val players: List<PlayersItem?>? = listOf(),

	@field:SerializedName("team_key")
	val teamKey: String? = "",

	@field:SerializedName("team_name")
	val teamName: String? = "",

	@field:SerializedName("team_logo")
	val teamLogo: String? = ""
)

data class PlayersItem(

	@field:SerializedName("player_key")
	val playerKey: Long? = 0,

	@field:SerializedName("player_match_played")
	val playerMatchPlayed: String? = "",

	@field:SerializedName("player_age")
	val playerAge: String? = "",

	@field:SerializedName("player_red_cards")
	val playerRedCards: String? = "",

	@field:SerializedName("player_number")
	val playerNumber: String? = "",

	@field:SerializedName("player_country")
	val playerCountry: Any? = "",

	@field:SerializedName("player_image")
	val playerImage: String? = "",

	@field:SerializedName("player_goals")
	val playerGoals: String? = "",

	@field:SerializedName("player_name")
	val playerName: String? = "",

	@field:SerializedName("player_yellow_cards")
	val playerYellowCards: String? = "",

	@field:SerializedName("player_type")
	val playerType: String? = ""
)
