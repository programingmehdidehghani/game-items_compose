package com.example.game_api_compose.domain.usecase.maps

import com.example.game_api_compose.common.Resource
import com.example.game_api_compose.data.model.maps.toMap
import com.example.game_api_compose.domain.repository.ValorantRepository
import com.example.game_api_compose.domain.model.Map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMapDetailUseCase @Inject constructor(
    private val valorantRepository: ValorantRepository
) {
    operator fun invoke(mapUuid: String): Flow<Resource<Map>> = flow {
        try {
            emit(Resource.Loading)
            valorantRepository.getMapByUuid(mapUuid).data?.toMap()?.let {
                emit(Resource.Success(it))
            }

        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }catch (e: IOException){
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }
    }
}