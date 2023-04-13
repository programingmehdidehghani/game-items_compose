package com.example.game_api_compose.data.remote

import com.example.game_api_compose.data.model.CompetitiveTier.CompetitiveTiersResponse
import com.example.game_api_compose.data.model.agents.AgentDetailResponse
import com.example.game_api_compose.data.model.agents.AgentResponse
import com.example.game_api_compose.data.model.maps.MapDetailResponse
import com.example.game_api_compose.data.model.maps.MapsResponse
import com.example.game_api_compose.data.model.weapons.WeaponDetailResponse
import com.example.game_api_compose.data.model.weapons.WeaponsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ValorantService {

    @GET("v1/agents/?isPlayableCharacter=true")
    suspend fun getAgents(): AgentResponse

    @GET("v1/agents/{agentUuid}")
    suspend fun getAgentByUuid(@Path ("agentUuid") agentUuid: String): AgentDetailResponse

    @GET("v1/maps")
    suspend fun getMaps(): MapsResponse

    @GET("v1/maps/{mapUuid}")
    suspend fun getMapByUuid(@Path ("mapUuid") mapUuid: String): MapDetailResponse

    @GET("v1/weapons")
    suspend fun getWeapons(): WeaponsResponse

    @GET("v1/weapons/{weaponUuid}")
    suspend fun getWeaponByUuid(@Path ("weaponUuid") weaponUuid: String): WeaponDetailResponse

    @GET("v1/competitivetiers")
    suspend fun getCompetitiveTiers(): CompetitiveTiersResponse
}