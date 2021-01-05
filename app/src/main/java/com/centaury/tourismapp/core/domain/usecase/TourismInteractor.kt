package com.centaury.tourismapp.core.domain.usecase

import com.centaury.tourismapp.core.data.Resource
import com.centaury.tourismapp.core.domain.model.Tourism
import com.centaury.tourismapp.core.domain.repository.ITourismRepository
import io.reactivex.Flowable

/**
 * @Author Centaury (alfa.arnialfa@gmail.com)
 * Created by Centaury on 1/3/2021.
 */
class TourismInteractor(private val tourismRepository: ITourismRepository) : TourismUseCase {
    override fun getAllTourism(): Flowable<Resource<List<Tourism>>> =
        tourismRepository.getAllTourism()

    override fun getFavoriteTourism(): Flowable<List<Tourism>> =
        tourismRepository.getFavoriteTourism()

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) =
        tourismRepository.setFavoriteTourism(tourism, state)

}