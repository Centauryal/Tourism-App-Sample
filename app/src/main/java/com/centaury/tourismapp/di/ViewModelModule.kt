package com.centaury.tourismapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.centaury.tourismapp.core.ui.ViewModelFactory
import com.centaury.tourismapp.detail.DetailTourismViewModel
import com.centaury.tourismapp.favorite.FavoriteViewModel
import com.centaury.tourismapp.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @Author Centaury (alfa.arnialfa@gmail.com)
 * Created by Centaury on 1/11/2021.
 */
@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteViewModel::class)
    abstract fun bindFavoriteViewModel(viewModel: FavoriteViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailTourismViewModel::class)
    abstract fun bindDetailTourismViewModel(viewModel: DetailTourismViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}