package com.centaury.tourismapp.core.di

import androidx.room.Room
import com.centaury.tourismapp.core.data.TourismRepository
import com.centaury.tourismapp.core.data.source.local.LocalDataSource
import com.centaury.tourismapp.core.data.source.local.room.TourismDatabase
import com.centaury.tourismapp.core.data.source.remote.RemoteDataSource
import com.centaury.tourismapp.core.data.source.remote.network.ApiService
import com.centaury.tourismapp.core.domain.repository.ITourismRepository
import com.centaury.tourismapp.core.utils.AppExecutors
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @Author Centaury (alfa.arnialfa@gmail.com)
 * Created by Centaury on 1/6/2021.
 */
val databaseModule = module {
    factory { get<TourismDatabase>().tourismDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            TourismDatabase::class.java, "Tourism.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://tourism-api.dicoding.dev/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<ITourismRepository> { TourismRepository(get(), get(), get()) }
}