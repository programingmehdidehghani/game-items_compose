package com.example.game_api_compose.navigation

import com.example.game_api_compose.R
import com.example.game_api_compose.common.Constants

sealed class BottomNavItem(
    val title: String,
    val image: Int,
    val route: String
){

}
