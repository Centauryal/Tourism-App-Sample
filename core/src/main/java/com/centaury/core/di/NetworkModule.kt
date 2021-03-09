package com.centaury.core.di

import com.centaury.core.data.source.remote.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @Author Centaury (alfa.arnialfa@gmail.com)
 * Created by Centaury on 1/7/2021.
 */
@Module
@InstallIn(ApplicationComponent::class)
class NetworkModule {

    @Provides
    fun provideOkHttpCLient(): OkHttpClient {
        val hostname = "tourism-api.dicoding.dev"
        val certificatePinner = CertificatePinner.Builder()
             .add(hostname, "sha256/efJRcxel8l8esct4H2iQRwcvs79t8AKGlcgiaBPor98=")
             .build()
        return OkHttpClient.Builder()
             .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
             .connectTimeout(120, TimeUnit.SECONDS)
             .readTimeout(120, TimeUnit.SECONDS)
             .certificatePinner(certificatePinner)
             .build()
    }

    @Provides
    fun provideApiService(client: OkHttpClient): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://tourism-api.dicoding.dev/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create(ApiService::class.java)
    }
}