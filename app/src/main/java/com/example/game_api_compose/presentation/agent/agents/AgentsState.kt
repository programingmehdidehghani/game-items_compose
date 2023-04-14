package com.example.game_api_compose.presentation.agent.agents

import android.text.BoringLayout
import com.example.game_api_compose.domain.model.Agent

data class AgentsState(
    val isLoading: Boolean = false,
    val agents: List<Agent> = emptyList(),
    val error: String = ""
)
