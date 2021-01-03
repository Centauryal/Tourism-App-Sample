package com.centaury.tourismapp.core.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.centaury.tourismapp.core.data.source.remote.network.ApiResponse
import com.centaury.tourismapp.core.data.source.remote.network.ApiService
import com.centaury.tourismapp.core.data.source.remote.response.PlacesItem
import com.centaury.tourismapp.core.data.source.remote.response.TourismResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor(private val apiService: ApiService) {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service)
            }
    }

    fun getAllTourism(): LiveData<ApiResponse<List<PlacesItem>>> {
        val resultData = MutableLiveData<ApiResponse<List<PlacesItem>>>()

        //get data from remote api
        val client = apiService.getList()

        client.enqueue(object : Callback<TourismResponse> {
            override fun onResponse(
                call: Call<TourismResponse>,
                response: Response<TourismResponse>
            ) {
                val dataArray = response.body()?.places
                resultData.value =
                    if (dataArray != null) ApiResponse.Success(dataArray) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<TourismResponse>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource", t.message.toString())
            }

        })

        return resultData
    }
}

