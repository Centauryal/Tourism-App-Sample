package com.centaury.core.di

import android.content.Context
import androidx.room.Room
import com.centaury.core.data.source.local.room.TourismDao
import com.centaury.core.data.source.local.room.TourismDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

/**
 * @Author Centaury (alfa.arnialfa@gmail.com)
 * Created by Centaury on 1/7/2021.
 */
@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): TourismDatabase {
        val builder = Room.databaseBuilder(context, TourismDatabase::class.java, "Tourism.db")
                .fallbackToDestructiveMigration()
        val factory = SupportFactory(SQLiteDatabase.getBytes("TourismApps".toCharArray()))

        builder.openHelperFactory(factory)

        return builder.build()
    }

    @Provides
    fun provideTourismDao(database: TourismDatabase): TourismDao = database.tourismDao()
}