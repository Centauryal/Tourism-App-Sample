package com.centaury.tourismapp.di

import com.centaury.tourismapp.core.domain.usecase.TourismInteractor
import com.centaury.tourismapp.core.domain.usecase.TourismUseCase
import dagger.Binds
import dagger.Module

/**
 * @Author Centaury (alfa.arnialfa@gmail.com)
 * Created by Centaury on 1/7/2021.
 */
@Module
abstract class AppModule {

    @Binds
    abstract fun provideTourismUseCase(tourismInteractor: TourismInteractor): TourismUseCase
}