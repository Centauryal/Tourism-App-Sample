package com.centaury.tourismapp.core.data.source.remote

import android.annotation.SuppressLint
import android.util.Log
import com.centaury.tourismapp.core.data.source.remote.network.ApiResponse
import com.centaury.tourismapp.core.data.source.remote.network.ApiService
import com.centaury.tourismapp.core.data.source.remote.response.PlacesItem
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

class RemoteDataSource private constructor(private val apiService: ApiService) {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service)
            }
    }

    @SuppressLint("CheckResult")
    fun getAllTourism(): Flowable<ApiResponse<List<PlacesItem>>> {
        val resultData = PublishSubject.create<ApiResponse<List<PlacesItem>>>()

        //get data from remote api
        val client = apiService.getList()

        client
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe({ response ->
                val dataArray = response.places
                resultData.onNext(if (dataArray.isNotEmpty()) ApiResponse.Success(dataArray) else ApiResponse.Empty)
            }, { error ->
                resultData.onNext(ApiResponse.Error(error.message.toString()))
                Log.e("RemoteDataSource ", error.toString())
            })

        return resultData.toFlowable(BackpressureStrategy.BUFFER)
    }
}

