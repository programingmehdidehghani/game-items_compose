package com.example.game_api_compose.presentation.weapon.weapons

import com.example.game_api_compose.domain.model.Weapon

data class WeaponsState(
    val isLoading: Boolean = false,
    val weapons: List<Weapon> = emptyList(),
    val error: String =""
)
