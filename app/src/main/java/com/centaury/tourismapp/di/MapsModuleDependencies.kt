package com.centaury.tourismapp.di

import com.centaury.core.domain.usecase.TourismUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

/**
 * @Author Centaury (alfa.arnialfa@gmail.com)
 * Created by Centaury on 1/19/2021.
 */
@EntryPoint
@InstallIn(ApplicationComponent::class)
interface MapsModuleDependencies {

    fun tourismUseCase(): TourismUseCase
}