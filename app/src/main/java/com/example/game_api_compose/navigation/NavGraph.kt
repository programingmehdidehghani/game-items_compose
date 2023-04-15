package com.example.game_api_compose.navigation

import android.window.SplashScreen
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.game_api_compose.presentation.agent.agentDetail.AgentDetailScreen
import com.example.game_api_compose.presentation.agent.agents.AgentsScreen
import com.example.game_api_compose.presentation.competitivetiers.CompetitiveTiersScreen
import com.example.game_api_compose.presentation.map.mapDetail.MapDetailScreen
import com.example.game_api_compose.presentation.map.maps.MapsScreen
import com.example.game_api_compose.presentation.splash.SplashScreen
import com.example.game_api_compose.presentation.weapon.weapondetail.WeaponDetailScreen
import com.example.game_api_compose.presentation.weapon.weapons.WeaponsScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun NavGraph(navController: NavHostController,paddingValues: PaddingValues){

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route,
        modifier = Modifier.padding(paddingValues = paddingValues)
    ){
        composable(route = Screen.Splash.route){
            SplashScreen(
                navigateToAgents = {
                    navController.navigate(Screen.Agents.route){
                        popUpTo(Screen.Splash.route){
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(route = Screen.Agents.route){
            AgentsScreen(
                navigateToAgentDetail = {
                    navController.navigate("${Screen.MapDetail.route}/$it")
                }
            )
        }

        composable(route = "${Screen.AgentDetail.route}/{agentUuid}"){
            AgentDetailScreen()
        }

        composable(route = Screen.Maps.route){
            MapsScreen(
                navigateToMapDetail = {
                    navController.navigate("${Screen.MapDetail.route}$it")
                }
            )
        }

        composable(route = "${Screen.MapDetail.route}/{mapUuid}") {
            MapDetailScreen()
        }

        composable(route = Screen.Weapons.route){
            WeaponsScreen(
                navigateToWeaponDetail = {
                    navController.navigate("${Screen.WeaponDetail.route}/$it")
                }
            )
        }

        composable(route = "${Screen.WeaponDetail.route}/{weaponUuid}"){
            WeaponDetailScreen()
        }

        composable(route = Screen.CompetitiveTiers.route){
            CompetitiveTiersScreen()
        }

    }
}