package com.example.game_api_compose.data.model.CompetitiveTier

import com.google.gson.annotations.SerializedName

data class CompetitiveTier(
    @SerializedName("assetObjectName")
    val assetObjectName: String?,
    @SerializedName("assetPath")
    val assetPath: String?,
    @SerializedName("tiers")
    val tiers: List<TierDto>?,
    @SerializedName("uuid")
    val uuid: String?
)
