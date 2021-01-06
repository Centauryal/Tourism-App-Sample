package com.centaury.tourismapp.core.data

import com.centaury.tourismapp.core.data.source.local.LocalDataSource
import com.centaury.tourismapp.core.data.source.remote.RemoteDataSource
import com.centaury.tourismapp.core.data.source.remote.network.ApiResponse
import com.centaury.tourismapp.core.data.source.remote.response.PlacesItem
import com.centaury.tourismapp.core.domain.model.Tourism
import com.centaury.tourismapp.core.domain.repository.ITourismRepository
import com.centaury.tourismapp.core.utils.AppExecutors
import com.centaury.tourismapp.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TourismRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ITourismRepository {

    override fun getAllTourism(): Flow<Resource<List<Tourism>>> =
        object : NetworkBoundResource<List<Tourism>, List<PlacesItem>>() {
            override fun loadFromDB(): Flow<List<Tourism>> {
                return localDataSource.getAllTourism().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Tourism>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<PlacesItem>>> =
                remoteDataSource.getAllTourism()

            override suspend fun saveCallResult(data: List<PlacesItem>) {
                val tourismList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertTourism(tourismList)
            }
        }.asFlow()

    override fun getFavoriteTourism(): Flow<List<Tourism>> {
        return localDataSource.getFavoriteTourism().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(tourism)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTourism(tourismEntity, state) }
    }
}

