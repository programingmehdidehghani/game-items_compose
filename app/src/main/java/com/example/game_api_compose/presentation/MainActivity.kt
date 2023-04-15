package com.example.game_api_compose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.game_api_compose.navigation.BottomNavigationBar
import com.example.game_api_compose.navigation.NavGraph
import com.example.game_api_compose.navigation.Screen
import com.example.game_api_compose.presentation.theme.Game_api_composeTheme
import com.example.game_api_compose.presentation.theme.ValoRed
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Game_api_composeTheme {
                val bottomBarState = rememberSaveable { (mutableStateOf(false)) }

                val navController = rememberNavController()

                val navBackStackEntry by navController.currentBackStackEntryAsState()

                when(navBackStackEntry?.destination?.route){
                     Screen.Splash.route -> bottomBarState.value = false
                    else -> bottomBarState.value = true
                }

                Scaffold(
                    backgroundColor = ValoRed,
                    bottomBar = { BottomNavigationBar(navController, bottomBarState) }
                ) {
                    NavGraph(navController = navController, it)
                }
            }
        }
    }
}

