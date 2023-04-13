package com.example.game_api_compose.data.model.maps

import com.google.gson.annotations.SerializedName

data class MapDetailResponse(
    @SerializedName("data")
    val data: MapDto?,
    @SerializedName("status")
    val status: Int?
)
