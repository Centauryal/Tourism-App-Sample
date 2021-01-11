package com.centaury.tourismapp.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.centaury.tourismapp.core.domain.usecase.TourismUseCase
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(tourismUseCase: TourismUseCase) : ViewModel() {

    val favoriteTourism = tourismUseCase.getFavoriteTourism().asLiveData()

}

