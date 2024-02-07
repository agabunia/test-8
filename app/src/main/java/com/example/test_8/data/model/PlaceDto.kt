package com.example.test_8.data.model

import com.squareup.moshi.Json

data class PlaceDto(
    @Json(name = "id")
    val id: Int,
    @Json(name = "cover")
    val cover: String,
    @Json(name = "price")
    val price: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "location")
    val location: String,
    @Json(name = "reaction_count")
    var reactionCount: Int,
    @Json(name = "rate")
    var rate: Int
)
