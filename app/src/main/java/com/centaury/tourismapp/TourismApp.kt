package com.centaury.tourismapp

import android.app.Application
import com.centaury.tourismapp.core.di.databaseModule
import com.centaury.tourismapp.core.di.networkModule
import com.centaury.tourismapp.core.di.repositoryModule
import com.centaury.tourismapp.di.useCaseModule
import com.centaury.tourismapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * @Author Centaury (alfa.arnialfa@gmail.com)
 * Created by Centaury on 1/6/2021.
 */
class TourismApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@TourismApp)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}