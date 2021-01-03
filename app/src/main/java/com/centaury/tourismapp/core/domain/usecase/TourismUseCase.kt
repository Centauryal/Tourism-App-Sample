package com.centaury.tourismapp.core.domain.usecase

import androidx.lifecycle.LiveData
import com.centaury.tourismapp.core.data.Resource
import com.centaury.tourismapp.core.domain.model.Tourism

/**
 * @Author Centaury (alfa.arnialfa@gmail.com)
 * Created by Centaury on 1/3/2021.
 */
interface TourismUseCase {
    fun getAllTourism(): LiveData<Resource<List<Tourism>>>

    fun getFavoriteTourism(): LiveData<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}