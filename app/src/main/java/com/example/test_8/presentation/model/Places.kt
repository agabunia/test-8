package com.example.test_8.presentation.model

import java.io.Serializable

data class Places (
    val id: Int,
    val cover: String,
    val price: String,
    val title: String,
    val location: String,
    var reactionCount: Int,
    var rate: Int
): Serializable
