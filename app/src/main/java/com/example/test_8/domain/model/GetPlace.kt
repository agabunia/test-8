package com.example.test_8.domain.model

data class GetPlace(
    val id: Int,
    val cover: String,
    val price: String,
    val title: String,
    val location: String,
    var reactionCount: Int,
    var rate: Int
)
