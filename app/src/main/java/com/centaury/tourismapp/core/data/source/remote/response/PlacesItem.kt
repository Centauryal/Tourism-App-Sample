package com.centaury.tourismapp.core.data.source.remote.response

import com.squareup.moshi.Json

/**
 * @Author Centaury (alfa.arnialfa@gmail.com)
 * Created by Centaury on 1/3/2021.
 */
data class PlacesItem(
    @Json(name = "image")
    val image: String,

    @Json(name = "address")
    val address: String,

    @Json(name = "like")
    val like: Int,

    @Json(name = "latitude")
    val latitude: Double,

    @Json(name = "name")
    val name: String,

    @Json(name = "description")
    val description: String,

    @Json(name = "id")
    val id: Int,

    @Json(name = "longitude")
    val longitude: Double
)
