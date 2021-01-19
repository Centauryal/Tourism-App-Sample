package com.centaury.tourismapp.maps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.centaury.core.domain.usecase.TourismUseCase

/**
 * @Author Centaury (alfa.arnialfa@gmail.com)
 * Created by Centaury on 1/19/2021.
 */
class MapsViewModel(tourismUseCase: TourismUseCase) : ViewModel() {
    val tourism = tourismUseCase.getAllTourism().asLiveData()
}