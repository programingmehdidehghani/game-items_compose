package com.example.game_api_compose.domain.usecase.weapons

import com.example.game_api_compose.common.Resource
import com.example.game_api_compose.data.model.weapons.toWeapon
import com.example.game_api_compose.domain.model.Weapon
import com.example.game_api_compose.domain.repository.ValorantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetWeaponsUseCase @Inject constructor(
    private val valorantRepository: ValorantRepository
) {
    operator fun invoke(): Flow<Resource<List<Weapon>>> = flow {
        try {
            emit(Resource.Loading)
            valorantRepository.getWeapons().data?.map { it.toWeapon() }?.let {
                emit(Resource.Success(it))
            }

        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }catch (e: IOException){
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }
    }
}