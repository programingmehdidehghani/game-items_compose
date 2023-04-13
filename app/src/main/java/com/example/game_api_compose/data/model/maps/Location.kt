package com.example.game_api_compose.data.model.maps

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("x")
    val x: Double?,
    @SerializedName("y")
    val y: Double?
)
