package com.example.criptobenjaespi.core

import com.example.criptobenjaespi.data.remote.CriptoDataSource
import com.example.criptobenjaespi.data.remote.CriptoDataSourceImpl
import com.example.criptobenjaespi.data.repository.CriptoRepository
import com.example.criptobenjaespi.data.repository.CriptoRepositoryImpl
import com.example.criptobenjaespi.data.repository.WebService
import com.example.criptobenjaespi.utils.AppConstans
import com.google.gson.GsonBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
abstract class CriptoModule {
    @Binds
    abstract fun bindCriptoDataSource(criptoDataSourceImp: CriptoDataSourceImpl): CriptoDataSource

    @Binds
    abstract fun bindCriptoRepository(criptoRepositoryImpl: CriptoRepositoryImpl): CriptoRepository

    companion object {
        @Provides
        fun providesRetrofitInstance(): Retrofit{

            val loggingInterceptor = HttpLoggingInterceptor().also {
                it.level = HttpLoggingInterceptor.Level.BODY
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

            return Retrofit.Builder()
                .baseUrl(AppConstans.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }

        @Provides
        fun providesWebService(retrofit: Retrofit) = retrofit.create<WebService>()
    }

}