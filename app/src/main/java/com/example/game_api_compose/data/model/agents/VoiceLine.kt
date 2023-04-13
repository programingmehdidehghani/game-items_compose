package com.example.game_api_compose.data.model.agents

import com.google.gson.annotations.SerializedName

data class VoiceLine(
    @SerializedName("maxDuration")
    val maxDuration: Double?,
    @SerializedName("mediaList")
    val mediaList: List<Media>?,
    @SerializedName("minDuration")
    val minDuration: Double?
)
