package com.example.game_api_compose.domain.repository

import com.example.game_api_compose.data.model.CompetitiveTier.CompetitiveTiersResponse
import com.example.game_api_compose.data.model.agents.AgentDetailResponse
import com.example.game_api_compose.data.model.agents.AgentResponse
import com.example.game_api_compose.data.model.maps.MapDetailResponse
import com.example.game_api_compose.data.model.maps.MapsResponse
import com.example.game_api_compose.data.model.weapons.WeaponDetailResponse
import com.example.game_api_compose.data.model.weapons.WeaponsResponse

interface ValorantRepository {

    suspend fun getAgents(): AgentResponse

    suspend fun getAgentByUuid(agentUuid: String): AgentDetailResponse

    suspend fun getMaps(): MapsResponse

    suspend fun getMapByUuid(mapUuid: String): MapDetailResponse

    suspend fun getWeapons(): WeaponsResponse

    suspend fun getWeaponByUuid(weaponUuid: String): WeaponDetailResponse

    suspend fun getCompetitiveTiers(): CompetitiveTiersResponse
}