package com.centaury.tourismapp.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.centaury.tourismapp.core.domain.model.Tourism
import com.centaury.tourismapp.core.domain.usecase.TourismUseCase

class DetailTourismViewModel @ViewModelInject constructor(private val tourismUseCase: TourismUseCase) :
    ViewModel() {
    fun setFavoriteTourism(tourism: Tourism, newStatus: Boolean) =
        tourismUseCase.setFavoriteTourism(tourism, newStatus)
}

