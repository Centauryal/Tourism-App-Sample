package com.centaury.tourismapp.core.data.source.remote

import android.util.Log
import com.centaury.tourismapp.core.data.source.remote.network.ApiResponse
import com.centaury.tourismapp.core.data.source.remote.network.ApiService
import com.centaury.tourismapp.core.data.source.remote.response.PlacesItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getAllTourism(): Flow<ApiResponse<List<PlacesItem>>> {
        return flow {
            try {
                val response = apiService.getList()
                val dataArray = response.places
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.places))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}

