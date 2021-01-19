package com.centaury.tourismapp.maps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.centaury.core.domain.usecase.TourismUseCase
import javax.inject.Inject

/**
 * @Author Centaury (alfa.arnialfa@gmail.com)
 * Created by Centaury on 1/19/2021.
 */
class ViewModelFactory @Inject constructor(private val tourismUseCase: TourismUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(MapsViewModel::class.java) -> {
                MapsViewModel(tourismUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}