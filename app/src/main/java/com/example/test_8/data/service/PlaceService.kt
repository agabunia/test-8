package com.example.test_8.data.service

import com.example.test_8.data.model.PlaceDto
import retrofit2.Response
import retrofit2.http.GET

interface PlaceService {
    @GET("https://run.mocky.io/v3/0545ddc1-c487-46ce-b70c-5b95270d6b76")
    suspend fun getPlaces(): Response<List<PlaceDto>>
}
