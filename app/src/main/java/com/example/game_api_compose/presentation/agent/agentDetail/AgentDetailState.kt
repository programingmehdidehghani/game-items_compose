package com.example.game_api_compose.presentation.agent.agentDetail

import com.example.game_api_compose.domain.model.Agent

data class AgentDetailState(
    val isLoading: Boolean = false,
    val agent: Agent? = null,
    val error: String = ""
)
