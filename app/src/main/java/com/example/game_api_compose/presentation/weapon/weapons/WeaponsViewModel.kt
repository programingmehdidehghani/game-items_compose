package com.example.game_api_compose.presentation.weapon.weapons

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.game_api_compose.common.Resource
import com.example.game_api_compose.domain.usecase.weapons.GetWeaponsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class WeaponsViewModel @Inject constructor(
    private val getWeaponsUseCase: GetWeaponsUseCase
): ViewModel() {

    private val _state = mutableStateOf(WeaponsState())
    val state: State<WeaponsState> = _state

    init {

    }

    fun getWeapons(){
        getWeaponsUseCase().onEach { result ->
            when(result){
                Resource.Loading -> _state.value = WeaponsState(isLoading = true)
                is Resource.Success -> _state.value = WeaponsState(weapons = result.data)
                is Resource.Error -> _state.value = WeaponsState(error = result.errorMessage)
            }
        }.launchIn(viewModelScope)
    }
}