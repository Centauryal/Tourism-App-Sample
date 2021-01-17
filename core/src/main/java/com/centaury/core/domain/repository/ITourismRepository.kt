package com.centaury.core.domain.repository

import com.centaury.core.data.Resource
import com.centaury.core.domain.model.Tourism
import kotlinx.coroutines.flow.Flow

/**
 * @Author Centaury (alfa.arnialfa@gmail.com)
 * Created by Centaury on 1/3/2021.
 */
interface ITourismRepository {
    fun getAllTourism(): Flow<Resource<List<Tourism>>>

    fun getFavoriteTourism(): Flow<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}