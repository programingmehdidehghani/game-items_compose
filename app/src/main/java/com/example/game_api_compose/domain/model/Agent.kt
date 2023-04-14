package com.example.game_api_compose.domain.model

import com.example.game_api_compose.data.model.agents.Ability
import com.example.game_api_compose.data.model.agents.Role

data class Agent(
    val abilities: List<Ability>,
    val description: String,
    val displayIcon: String,
    val displayName: String,
    val fullPortrait: String,
    val role: Role?,
    val uuid: String
)
