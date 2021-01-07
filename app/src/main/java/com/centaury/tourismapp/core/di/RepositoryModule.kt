package com.centaury.tourismapp.core.di

import com.centaury.tourismapp.core.data.TourismRepository
import com.centaury.tourismapp.core.domain.repository.ITourismRepository
import dagger.Binds
import dagger.Module

/**
 * @Author Centaury (alfa.arnialfa@gmail.com)
 * Created by Centaury on 1/7/2021.
 */
@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(tourismRepository: TourismRepository): ITourismRepository
}