package com.example.angelix_vasquez_ap2_p2.di

import com.example.angelix_vasquez_ap2_p2.data.remote.api.DepositoApiServices
import com.example.angelix_vasquez_ap2_p2.data.repository.DepositoRepositoryImp
import com.example.angelix_vasquez_ap2_p2.domain.repository.DepositoRepository
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

@Module
@InstallIn(SingletonComponent::class)

object ApiModule  {
    private const val BASE_URL = "https://gestionhuacalesapi.azurewebsites.net/swagger/v1/swagger.json"

    @Singleton
    @Provides
    fun provideMoshi() : Moshi =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()


    @Singleton
    @Provides
    fun provideOkHttpClient() : OkHttpClient =
        OkHttpClient.Builder().build()

    @Singleton
    @Provides
    fun provideRetrofit(moshi: Moshi, okHttpClient: OkHttpClient) : Retrofit =
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun DepositoApiService(retrofit: Retrofit) : DepositoApiServices =
        retrofit.create(DepositoApiServices::class.java)

    @Provides
    @Singleton
    fun DepositoRepository(apiService : DepositoApiServices) : DepositoRepository =
        DepositoRepositoryImp(apiService)
}