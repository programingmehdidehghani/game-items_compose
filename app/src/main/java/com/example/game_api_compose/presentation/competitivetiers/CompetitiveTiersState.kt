package com.example.game_api_compose.presentation.competitivetiers

import com.example.game_api_compose.domain.model.Tier

data class CompetitiveTiersState(
    val isLoading: Boolean = false,
    val tier: List<Tier> = emptyList(),
    val error: String = ""
)
