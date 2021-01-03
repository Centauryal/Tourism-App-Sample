package com.centaury.tourismapp.core.domain.usecase

import androidx.lifecycle.LiveData
import com.centaury.tourismapp.core.data.Resource
import com.centaury.tourismapp.core.domain.model.Tourism
import com.centaury.tourismapp.core.domain.repository.ITourismRepository

/**
 * @Author Centaury (alfa.arnialfa@gmail.com)
 * Created by Centaury on 1/3/2021.
 */
class TourismInteractor(private val tourismRepository: ITourismRepository) : TourismUseCase {
    override fun getAllTourism(): LiveData<Resource<List<Tourism>>> =
        tourismRepository.getAllTourism()

    override fun getFavoriteTourism(): LiveData<List<Tourism>> =
        tourismRepository.getFavoriteTourism()

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) =
        tourismRepository.setFavoriteTourism(tourism, state)

}