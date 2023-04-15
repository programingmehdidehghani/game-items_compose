package com.example.game_api_compose.presentation.map.maps

import com.example.game_api_compose.domain.model.Map

data class MapsState(
    val isLoading: Boolean = false,
    val maps: List<Map> = emptyList(),
    val error: String = ""
)
