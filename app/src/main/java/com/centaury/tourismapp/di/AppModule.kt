package com.centaury.tourismapp.di

import com.centaury.tourismapp.core.domain.usecase.TourismInteractor
import com.centaury.tourismapp.core.domain.usecase.TourismUseCase
import com.centaury.tourismapp.detail.DetailTourismViewModel
import com.centaury.tourismapp.favorite.FavoriteViewModel
import com.centaury.tourismapp.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @Author Centaury (alfa.arnialfa@gmail.com)
 * Created by Centaury on 1/6/2021.
 */
val useCaseModule = module {
    factory<TourismUseCase> { TourismInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { DetailTourismViewModel(get()) }
}