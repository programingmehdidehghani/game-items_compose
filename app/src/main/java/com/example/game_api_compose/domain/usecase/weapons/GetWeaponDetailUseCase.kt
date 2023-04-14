package com.example.game_api_compose.domain.usecase.weapons

import com.example.game_api_compose.common.Resource
import com.example.game_api_compose.data.model.weapons.Skin
import com.example.game_api_compose.data.model.weapons.toWeapon
import com.example.game_api_compose.domain.model.Weapon
import com.example.game_api_compose.domain.repository.ValorantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetWeaponDetailUseCase @Inject constructor(
    private val valorantRepository: ValorantRepository
) {
    fun getWeaponDetailByUuid(weaponUuid: String): Flow<Resource<Weapon>> = flow {
        try {
            emit(Resource.Loading)
            valorantRepository.getWeaponByUuid(weaponUuid).data?.toWeapon()?.let { weapon ->
                val skinsTemp = arrayListOf<Skin>()
                weapon.skins?.forEach { skin ->
                    if (skin.displayIcon.isNullOrEmpty()
                            .not() && skin.displayName.orEmpty().contains("Standard").not()
                    ){
                        skinsTemp.add(skin)
                    }
                }
            }

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }
    }
}