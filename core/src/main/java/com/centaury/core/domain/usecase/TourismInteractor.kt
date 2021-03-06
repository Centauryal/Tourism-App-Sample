package com.centaury.core.domain.usecase

import com.centaury.core.data.Resource
import com.centaury.core.domain.model.Tourism
import com.centaury.core.domain.repository.ITourismRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Centaury (alfa.arnialfa@gmail.com)
 * Created by Centaury on 1/3/2021.
 */
class TourismInteractor @Inject constructor(private val tourismRepository: ITourismRepository) :
    TourismUseCase {
    override fun getAllTourism(): Flow<Resource<List<Tourism>>> =
        tourismRepository.getAllTourism()

    override fun getFavoriteTourism(): Flow<List<Tourism>> =
        tourismRepository.getFavoriteTourism()

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) =
        tourismRepository.setFavoriteTourism(tourism, state)

}