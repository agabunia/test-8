package com.example.test_8.presentation.state

import com.example.test_8.presentation.model.Places

data class PlaceState(
    val data: List<Places>? = null,
    val errorMessage: String? = null,
    val loading: Boolean = false
)