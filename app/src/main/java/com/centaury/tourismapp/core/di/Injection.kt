package com.centaury.tourismapp.core.di

import android.content.Context
import com.centaury.tourismapp.core.data.TourismRepository
import com.centaury.tourismapp.core.data.source.local.LocalDataSource
import com.centaury.tourismapp.core.data.source.local.room.TourismDatabase
import com.centaury.tourismapp.core.data.source.remote.RemoteDataSource
import com.centaury.tourismapp.core.data.source.remote.network.ApiConfig
import com.centaury.tourismapp.core.domain.repository.ITourismRepository
import com.centaury.tourismapp.core.domain.usecase.TourismInteractor
import com.centaury.tourismapp.core.domain.usecase.TourismUseCase
import com.centaury.tourismapp.core.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): ITourismRepository {
        val database = TourismDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val localDataSource = LocalDataSource.getInstance(database.tourismDao())
        val appExecutors = AppExecutors()

        return TourismRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideTourismUseCase(context: Context): TourismUseCase {
        val repository = provideRepository(context)
        return TourismInteractor(repository)
    }
}
