package com.example.game_api_compose.domain.model

import com.example.game_api_compose.data.model.weapons.Skin
import com.example.game_api_compose.data.model.weapons.WeaponStats

data class Weapon(
    val category: String?,
    val displayIcon: String?,
    val displayName: String?,
    var skins: List<Skin>?,
    val uuid: String?,
    val weaponStats: WeaponStats?
)
