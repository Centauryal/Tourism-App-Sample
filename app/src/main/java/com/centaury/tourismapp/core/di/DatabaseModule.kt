package com.centaury.tourismapp.core.di

import android.content.Context
import androidx.room.Room
import com.centaury.tourismapp.core.data.source.local.room.TourismDao
import com.centaury.tourismapp.core.data.source.local.room.TourismDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @Author Centaury (alfa.arnialfa@gmail.com)
 * Created by Centaury on 1/7/2021.
 */
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): TourismDatabase = Room.databaseBuilder(
        context,
        TourismDatabase::class.java, "Tourism.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideTourismDao(database: TourismDatabase): TourismDao = database.tourismDao()
}