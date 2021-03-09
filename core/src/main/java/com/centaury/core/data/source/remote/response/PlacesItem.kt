package com.centaury.core.data.source.remote.response

import androidx.annotation.Keep
import com.squareup.moshi.Json

/**
 * @Author Centaury (alfa.arnialfa@gmail.com)
 * Created by Centaury on 1/3/2021.
 */
@Keep
data class PlacesItem(
    @field:Json(name = "image")
    val image: String,

    @field:Json(name = "address")
    val address: String,

    @field:Json(name = "like")
    val like: Int,

    @field:Json(name = "latitude")
    val latitude: Double,

    @field:Json(name = "name")
    val name: String,

    @field:Json(name = "description")
    val description: String,

    @field:Json(name = "id")
    val id: Int,

    @field:Json(name = "longitude")
    val longitude: Double
)
