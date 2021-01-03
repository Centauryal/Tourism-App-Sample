package com.centaury.tourismapp.core.data.source.remote.response

import com.squareup.moshi.Json

data class TourismResponse(

    @Json(name = "places")
    val places: List<PlacesItem>,

    @Json(name = "count")
    val count: Int,

    @Json(name = "error")
    val error: Boolean,

    @Json(name = "message")
    val message: String
)
