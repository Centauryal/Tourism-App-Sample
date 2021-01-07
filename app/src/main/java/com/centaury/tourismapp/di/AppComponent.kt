package com.centaury.tourismapp.di

import com.centaury.tourismapp.core.di.CoreComponent
import com.centaury.tourismapp.detail.DetailTourismActivity
import com.centaury.tourismapp.favorite.FavoriteFragment
import com.centaury.tourismapp.home.HomeFragment
import dagger.Component

/**
 * @Author Centaury (alfa.arnialfa@gmail.com)
 * Created by Centaury on 1/7/2021.
 */
@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(fragment: HomeFragment)
    fun inject(fragment: FavoriteFragment)
    fun inject(activity: DetailTourismActivity)
}