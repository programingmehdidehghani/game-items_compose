package com.example.game_api_compose.data.model.maps

import com.google.gson.annotations.SerializedName

data class Callout(
    @SerializedName("location")
    val location: Location?,
    @SerializedName("regionName")
    val regionName: String?,
    @SerializedName("superRegionName")
    val superRegionName: String?
)
