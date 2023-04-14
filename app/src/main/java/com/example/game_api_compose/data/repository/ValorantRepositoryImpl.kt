package com.example.game_api_compose.data.repository

import com.example.game_api_compose.data.model.CompetitiveTier.CompetitiveTiersResponse
import com.example.game_api_compose.data.model.agents.AgentDetailResponse
import com.example.game_api_compose.data.model.agents.AgentResponse
import com.example.game_api_compose.data.model.maps.MapDetailResponse
import com.example.game_api_compose.data.model.maps.MapsResponse
import com.example.game_api_compose.data.model.weapons.WeaponDetailResponse
import com.example.game_api_compose.data.model.weapons.WeaponsResponse
import com.example.game_api_compose.data.remote.ValorantService
import com.example.game_api_compose.domain.repository.ValorantRepository

class ValorantRepositoryImpl(private val valorantService: ValorantService): ValorantRepository {
    override suspend fun getAgents(): AgentResponse = valorantService.getAgents()

    override suspend fun getAgentByUuid(agentUuid: String): AgentDetailResponse = valorantService.getAgentByUuid(agentUuid)

    override suspend fun getMaps(): MapsResponse = valorantService.getMaps()

    override suspend fun getMapByUuid(mapUuid: String): MapDetailResponse = valorantService.getMapByUuid(mapUuid)

    override suspend fun getWeapons(): WeaponsResponse = valorantService.getWeapons()

    override suspend fun getWeaponByUuid(weaponUuid: String): WeaponDetailResponse = valorantService.getWeaponByUuid(weaponUuid)

    override suspend fun getCompetitiveTiers(): CompetitiveTiersResponse = valorantService.getCompetitiveTiers()
}