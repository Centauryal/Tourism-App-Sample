package com.centaury.tourismapp.detail

import androidx.lifecycle.ViewModel
import com.centaury.tourismapp.core.domain.model.Tourism
import com.centaury.tourismapp.core.domain.usecase.TourismUseCase

class DetailTourismViewModel(private val tourismUseCase: TourismUseCase) : ViewModel() {
    fun setFavoriteTourism(tourism: Tourism, newStatus: Boolean) =
        tourismUseCase.setFavoriteTourism(tourism, newStatus)
}
