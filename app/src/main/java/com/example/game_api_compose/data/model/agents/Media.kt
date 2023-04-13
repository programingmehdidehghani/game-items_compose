package com.example.game_api_compose.data.model.agents

import com.google.gson.annotations.SerializedName

data class Media(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("wave")
    val wave: String?,
    @SerializedName("wwise")
    val wwise: String?
)
