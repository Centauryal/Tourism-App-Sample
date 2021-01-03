package com.centaury.tourismapp.home

import androidx.lifecycle.ViewModel
import com.centaury.tourismapp.core.domain.usecase.TourismUseCase

class HomeViewModel(tourismUseCase: TourismUseCase) : ViewModel() {

    val tourism = tourismUseCase.getAllTourism()

}

