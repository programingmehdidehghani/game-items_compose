package com.example.game_api_compose.data.model.CompetitiveTier

import com.google.gson.annotations.SerializedName

data class CompetitiveTiersResponse(
    @SerializedName("data")
    val data: List<CompetitiveTier>?,
    @SerializedName("status")
    val status: Int?
)
