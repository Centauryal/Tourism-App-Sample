package com.centaury.tourismapp.core.domain.usecase

import com.centaury.tourismapp.core.data.Resource
import com.centaury.tourismapp.core.domain.model.Tourism
import io.reactivex.Flowable

/**
 * @Author Centaury (alfa.arnialfa@gmail.com)
 * Created by Centaury on 1/3/2021.
 */
interface TourismUseCase {
    fun getAllTourism(): Flowable<Resource<List<Tourism>>>

    fun getFavoriteTourism(): Flowable<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}