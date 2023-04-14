package com.example.game_api_compose.domain.usecase.competitivetiers

import com.example.game_api_compose.common.Resource
import com.example.game_api_compose.data.model.CompetitiveTier.TierDto
import com.example.game_api_compose.domain.model.Tier
import com.example.game_api_compose.domain.repository.ValorantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCompetitiveTiersUseCase @Inject constructor(
    private val valorantRepository: ValorantRepository
) {

    operator fun invoke() : Flow<Resource<List<Tier>>> = flow {
        try {
            emit(Resource.Loading)
            valorantRepository.getCompetitiveTiers().data?.last()?.tiers?.let { tiers ->
                val tiersTemp = arrayListOf<TierDto>()
                tiers.forEach { tier ->
                    if (tier.rankTriangleUpIcon != null){
                         tiersTemp.add(tier)
                    }
                }
            }

        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }catch (e: IOException){
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }
    }
}