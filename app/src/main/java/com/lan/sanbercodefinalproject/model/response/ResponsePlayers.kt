package com.lan.sanbercodefinalproject.model.response

import com.google.gson.annotations.SerializedName

data class ResponsePlayers(

	@field:SerializedName("result")
	val result: List<ResultPlayerItem?>? = null,

	@field:SerializedName("success")
	val success: Int? = null
)

data class ResultPlayerItem(

	@field:SerializedName("player_shots_total")
	val playerShotsTotal: String? = null,

	@field:SerializedName("player_key_passes")
	val playerKeyPasses: String? = null,

	@field:SerializedName("player_goals_conceded")
	val playerGoalsConceded: String? = null,

	@field:SerializedName("player_age")
	val playerAge: String? = null,

	@field:SerializedName("player_fouls_commited")
	val playerFoulsCommited: String? = null,

	@field:SerializedName("player_pen_missed")
	val playerPenMissed: String? = null,

	@field:SerializedName("player_red_cards")
	val playerRedCards: String? = null,

	@field:SerializedName("player_dispossesed")
	val playerDispossesed: String? = null,

	@field:SerializedName("player_rating")
	val playerRating: String? = null,

	@field:SerializedName("player_number")
	val playerNumber: String? = null,

	@field:SerializedName("player_passes")
	val playerPasses: String? = null,

	@field:SerializedName("player_goals")
	val playerGoals: String? = null,

	@field:SerializedName("player_pen_won")
	val playerPenWon: String? = null,

	@field:SerializedName("player_name")
	val playerName: String? = null,

	@field:SerializedName("player_clearances")
	val playerClearances: String? = null,

	@field:SerializedName("player_blocks")
	val playerBlocks: String? = null,

	@field:SerializedName("player_interceptions")
	val playerInterceptions: String? = null,

	@field:SerializedName("player_match_played")
	val playerMatchPlayed: String? = null,

	@field:SerializedName("player_dribble_attempts")
	val playerDribbleAttempts: String? = null,

	@field:SerializedName("player_pen_scored")
	val playerPenScored: String? = null,

	@field:SerializedName("player_substitute_out")
	val playerSubstituteOut: String? = null,

	@field:SerializedName("player_saves")
	val playerSaves: String? = null,

	@field:SerializedName("player_duels_total")
	val playerDuelsTotal: String? = null,

	@field:SerializedName("player_crosses_total")
	val playerCrossesTotal: String? = null,

	@field:SerializedName("player_pen_comm")
	val playerPenComm: String? = null,

	@field:SerializedName("player_country")
	val playerCountry: Any? = null,

	@field:SerializedName("player_image")
	val playerImage: String? = null,

	@field:SerializedName("player_injured")
	val playerInjured: String? = null,

	@field:SerializedName("player_woordworks")
	val playerWoordworks: String? = null,

	@field:SerializedName("player_passes_accuracy")
	val playerPassesAccuracy: String? = null,

	@field:SerializedName("player_type")
	val playerType: String? = null,

	@field:SerializedName("team_key")
	val teamKey: String? = null,

	@field:SerializedName("player_dribble_succ")
	val playerDribbleSucc: String? = null,

	@field:SerializedName("team_name")
	val teamName: String? = null,

	@field:SerializedName("player_key")
	val playerKey: Int? = null,

	@field:SerializedName("player_minutes")
	val playerMinutes: String? = null,

	@field:SerializedName("player_substitutes_on_bench")
	val playerSubstitutesOnBench: String? = null,

	@field:SerializedName("player_assists")
	val playerAssists: String? = null,

	@field:SerializedName("player_is_captain")
	val playerIsCaptain: String? = null,

	@field:SerializedName("player_inside_box_saves")
	val playerInsideBoxSaves: String? = null,

	@field:SerializedName("player_duels_won")
	val playerDuelsWon: String? = null,

	@field:SerializedName("player_yellow_cards")
	val playerYellowCards: String? = null,

	@field:SerializedName("player_tackles")
	val playerTackles: String? = null
)
