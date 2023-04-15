package com.example.game_api_compose.presentation.map.maps

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.game_api_compose.common.Resource
import com.example.game_api_compose.domain.usecase.maps.GetMapsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(
    private val getMapsUseCase: GetMapsUseCase
) :ViewModel(){

    private val _state = mutableStateOf(MapsState())
    val state: State<MapsState> = _state

    init {
       getMaps()
    }

    private fun getMaps(){
        getMapsUseCase().onEach {result ->
            when(result){
                Resource.Loading -> _state.value = MapsState(isLoading = true)
                is Resource.Success -> _state.value = MapsState(maps = result.data)
                is Resource.Error -> _state.value = MapsState(error = result.errorMessage)
            }

        }
    }
}