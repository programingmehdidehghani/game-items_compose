package com.example.game_api_compose.di

import com.example.game_api_compose.data.remote.ValorantService
import com.example.game_api_compose.data.repository.ValorantRepositoryImpl
import com.example.game_api_compose.domain.repository.ValorantRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideValorantRepository(valorantService: ValorantService) : ValorantRepository{
         return ValorantRepositoryImpl(valorantService)
    }
}