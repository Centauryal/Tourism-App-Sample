package com.centaury.core.data.source.remote.response

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class TourismResponse(

    @field:Json(name = "places")
    val places: List<PlacesItem>,

    @field:Json(name = "count")
    val count: Int,

    @field:Json(name = "error")
    val error: Boolean,

    @field:Json(name = "message")
    val message: String
)
