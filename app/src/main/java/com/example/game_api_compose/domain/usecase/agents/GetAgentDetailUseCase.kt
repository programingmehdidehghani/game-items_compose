package com.example.game_api_compose.domain.usecase.agents

import com.example.game_api_compose.common.Resource
import com.example.game_api_compose.data.model.agents.toAgent
import com.example.game_api_compose.domain.model.Agent
import com.example.game_api_compose.domain.repository.ValorantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAgentDetailUseCase @Inject constructor(
    private val valorantRepository: ValorantRepository
) {
   operator fun invoke(agentUuid: String): Flow<Resource<Agent>> = flow {

       try {
           emit(Resource.Loading)
           valorantRepository.getAgentByUuid(agentUuid).data?.toAgent()?.let {
               emit(Resource.Success(it))
           }
       }catch (e: HttpException){
         emit(Resource.Error(e.localizedMessage.orEmpty()))
       }catch (e: IOException){
           emit(Resource.Error(e.localizedMessage.orEmpty()))
       }
   }

}