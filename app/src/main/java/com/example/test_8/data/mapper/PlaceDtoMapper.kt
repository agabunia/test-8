package com.example.test_8.data.mapper

import com.example.test_8.data.model.PlaceDto
import com.example.test_8.domain.model.GetPlace

fun PlaceDto.toDomain(): GetPlace {
    return GetPlace(
        id = id,
        cover = cover,
        price = price,
        title = title,
        location = location,
        reactionCount = reactionCount,
        rate = rate
    )
}
