package com.centaury.tourismapp.core.data.source.remote.network

import com.centaury.tourismapp.core.data.source.remote.response.TourismResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * @Author Centaury (alfa.arnialfa@gmail.com)
 * Created by Centaury on 1/3/2021.
 */
interface ApiService {
    @GET("list")
    fun getList(): Call<TourismResponse>
}