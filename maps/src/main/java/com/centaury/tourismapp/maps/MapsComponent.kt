package com.centaury.tourismapp.maps

import android.content.Context
import com.centaury.tourismapp.di.MapsModuleDependencies
import dagger.BindsInstance
import dagger.Component

/**
 * @Author Centaury (alfa.arnialfa@gmail.com)
 * Created by Centaury on 1/19/2021.
 */
@Component(dependencies = [MapsModuleDependencies::class])
interface MapsComponent {

    fun inject(activity: MapsActivity)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(mapsModuleDependencies: MapsModuleDependencies): Builder
        fun build(): MapsComponent
    }
}