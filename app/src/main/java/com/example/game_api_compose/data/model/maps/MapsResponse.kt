package com.example.game_api_compose.data.model.maps

import com.google.gson.annotations.SerializedName

data class MapsResponse(
    @SerializedName("data")
    val data: List<MapDto>?,
    @SerializedName("status")
    val status: Int?
)
