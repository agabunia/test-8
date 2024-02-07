package com.example.test_8.domain.repository

import com.example.test_8.data.common.Resource
import com.example.test_8.domain.model.GetPlace
import kotlinx.coroutines.flow.Flow

interface PlacesRepository {
    suspend fun getPlaces(): Flow<Resource<List<GetPlace>>>
}
