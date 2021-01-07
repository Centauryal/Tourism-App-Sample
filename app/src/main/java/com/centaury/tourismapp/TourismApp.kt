package com.centaury.tourismapp

import android.app.Application
import com.centaury.tourismapp.core.di.CoreComponent
import com.centaury.tourismapp.core.di.DaggerCoreComponent
import com.centaury.tourismapp.di.AppComponent
import com.centaury.tourismapp.di.DaggerAppComponent

/**
 * @Author Centaury (alfa.arnialfa@gmail.com)
 * Created by Centaury on 1/6/2021.
 */
class TourismApp : Application() {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }
}