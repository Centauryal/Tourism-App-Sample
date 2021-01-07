package com.centaury.tourismapp.core.di

import android.content.Context
import com.centaury.tourismapp.core.domain.repository.ITourismRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * @Author Centaury (alfa.arnialfa@gmail.com)
 * Created by Centaury on 1/7/2021.
 */
@Singleton
@Component(
    modules = [RepositoryModule::class]
)
interface CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): CoreComponent
    }

    fun provideRepository(): ITourismRepository
}