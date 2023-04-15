package com.example.game_api_compose.presentation.map.mapDetail

import com.example.game_api_compose.domain.model.Map

data class MapDetailState(
    val isLoading: Boolean = false,
    val map: Map? = null,
    val error: String =""
)
