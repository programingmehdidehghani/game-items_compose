package com.example.game_api_compose.presentation.agent.agents

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.game_api_compose.common.Resource
import com.example.game_api_compose.domain.model.Agent
import com.example.game_api_compose.domain.usecase.agents.GetAgentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class AgentsViewModel @Inject constructor(
    private val getAgentUseCase: GetAgentsUseCase
): ViewModel() {

    private var allAgents = listOf<Agent>()
    private val _state = mutableStateOf(AgentsState())
    val state: State<AgentsState> = _state

    private var _searchQuery = mutableStateOf("")
    val searchQuery: State<String> = _searchQuery

    init {
      getAgents()
    }

    private fun getAgents(){
       getAgentUseCase().onEach {result ->
           when(result){
              Resource.Loading -> _state.value = AgentsState(isLoading = false)
               is Resource.Success ->{
                   result.data.let {
                       _state.value = AgentsState(agents = it)
                       allAgents = it
                   }
               }
               is Resource.Error -> _state.value = AgentsState(error = result.errorMessage)
           }
       }.launchIn(viewModelScope)
    }

    fun searchAgent(query: String){
        _searchQuery.value = query
        _state.value = AgentsState(isLoading = true)

        val foundAgents =
            allAgents.filter {
                it.displayName.contains(query,true) or
                        it.description.contains(query,true)
            }
        if (foundAgents.isEmpty()){
            _state.value = AgentsState(error = "No agents matching with your search")
        } else{
            _state.value = AgentsState(agents = foundAgents)
        }
    }

    fun clearSearchQuery(){
        _state.value = AgentsState(agents = allAgents)
        _searchQuery.value = ""
    }
}