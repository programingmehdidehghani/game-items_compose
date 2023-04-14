package com.example.game_api_compose.domain.usecase.maps

import com.example.game_api_compose.common.Resource
import com.example.game_api_compose.data.model.maps.toMap
import com.example.game_api_compose.domain.repository.ValorantRepository
import kotlinx.coroutines.flow.Flow
import com.example.game_api_compose.domain.model.Map
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMapsUseCase @Inject constructor(
    private val valorantRepository: ValorantRepository
) {
    operator fun invoke(): Flow<Resource<List<Map>>> = flow {
        try {
            emit(Resource.Loading)
            valorantRepository.getMaps().data?.map { it.toMap() }?.let {
                emit(Resource.Success(it))
            }

        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }catch (e: IOException){
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }
    }
}