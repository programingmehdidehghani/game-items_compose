package com.example.game_api_compose.domain.usecase.agents

import com.example.game_api_compose.domain.repository.ValorantRepository
import javax.inject.Inject

class GetAgentUseCase @Inject constructor(
    private val valorantRepository: ValorantRepository
) {

    
}