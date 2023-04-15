package com.example.game_api_compose.presentation.weapon.weapondetail

import com.example.game_api_compose.domain.model.Weapon

data class WeaponDetailState(
    val isLoading: Boolean = false,
    val weapon: Weapon? = null,
    val error: String = ""
)
