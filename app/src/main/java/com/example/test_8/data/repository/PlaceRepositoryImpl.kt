package com.example.test_8.data.repository

import com.example.test_8.data.common.HandleResponse
import com.example.test_8.data.common.Resource
import com.example.test_8.data.mapper.asResource
import com.example.test_8.data.mapper.toDomain
import com.example.test_8.data.service.PlaceService
import com.example.test_8.domain.model.GetPlace
import com.example.test_8.domain.repository.PlacesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PlaceRepositoryImpl @Inject constructor(
    private val placeService: PlaceService,
    private val handleResponse: HandleResponse
) : PlacesRepository {
    override suspend fun getPlaces(): Flow<Resource<List<GetPlace>>> {
        return handleResponse.safeApiCall {
            placeService.getPlaces()
        }.asResource { list ->
            list.map { placeDto ->
                placeDto.toDomain()
            }
        }
    }
}
