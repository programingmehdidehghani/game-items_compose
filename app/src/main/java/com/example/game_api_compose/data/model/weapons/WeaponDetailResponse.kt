package com.example.game_api_compose.data.model.weapons

import com.google.gson.annotations.SerializedName

data class WeaponDetailResponse(
    @SerializedName("data")
    val data: WeaponDto?,
    @SerializedName("status")
    val status: Int?
)
