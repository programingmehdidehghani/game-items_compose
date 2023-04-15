package com.example.game_api_compose.presentation.map.mapDetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.game_api_compose.common.Constants
import com.example.game_api_compose.common.Resource
import com.example.game_api_compose.domain.usecase.maps.GetMapDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class MapDetailViewModel @Inject constructor(
    private val getMapDetailUseCase: GetMapDetailUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(MapDetailState())
    val state: State<MapDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_MAP_ID)?.let {mapId ->
            getMapDetail(mapId)
        }
    }

    private fun getMapDetail(mapUuid: String){
       getMapDetailUseCase(mapUuid).onEach {result ->
           when(result){
               Resource.Loading -> _state.value = MapDetailState(isLoading = true)
               is Resource.Success -> _state.value = MapDetailState(map = result.data)
               is Resource.Error -> _state.value = MapDetailState(error = result.errorMessage)
           }
       }
    }
}