package com.example.test_8.di

import com.example.test_8.data.common.HandleResponse
import com.example.test_8.data.repository.PlaceRepositoryImpl
import com.example.test_8.data.service.PlaceService
import com.example.test_8.domain.repository.PlacesRepository
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
    fun providePlacesRepository(
        handleResponse: HandleResponse,
        placeService: PlaceService
    ): PlacesRepository {
        return PlaceRepositoryImpl(handleResponse = handleResponse, placeService = placeService)
    }

}
