package com.example.test_8.presentation.mapper

import com.example.test_8.domain.model.GetPlace
import com.example.test_8.presentation.model.Places

fun GetPlace.toPresenter(): Places {
    return Places(
        id = id,
        cover = cover,
        price = price,
        title = title,
        location = location,
        reactionCount = reactionCount,
        rate = rate
    )
}
