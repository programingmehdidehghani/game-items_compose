package com.example.game_api_compose.data.model.weapons

import com.google.gson.annotations.SerializedName

data class GridPosition(
    @SerializedName("column")
    val column: Int?,
    @SerializedName("row")
    val row: Int?
)
