package com.example.game_api_compose.presentation.agent.agentDetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.game_api_compose.common.Constants
import com.example.game_api_compose.common.Resource
import com.example.game_api_compose.domain.usecase.agents.GetAgentDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AgentDetailViewModel @Inject constructor(
    private val getAgentDetailUseCase: GetAgentDetailUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel(){

    private val _state = mutableStateOf(AgentDetailState())
    val state: State<AgentDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_AGENT_ID)?.let {agentId ->

        }
    }

    private fun getAgentDetail(agentUuid: String){
          getAgentDetailUseCase(agentUuid).onEach { result ->
              when(result){
                  Resource.Loading -> _state.value = AgentDetailState(true)
                  is Resource.Success -> _state.value = AgentDetailState(agent = result.data)
                  is Resource.Error -> _state.value = AgentDetailState(error = result.errorMessage)
              }
          }.launchIn(viewModelScope)
    }

}