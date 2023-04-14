package com.example.game_api_compose.presentation.agent.agents

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.game_api_compose.domain.model.Agent
import com.example.game_api_compose.domain.usecase.agents.GetAgentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AgentsViewModel @Inject constructor(
    private val getAgentUseCase: GetAgentsUseCase
): ViewModel() {

    private var allAgents = listOf<Agent>()
    private val _state = mutableStateOf(AgentsState())
}