package com.example.criptobenjaespi.core

import android.content.Context
import androidx.room.Room
import com.example.criptobenjaespi.data.local.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val APP_DATABASE_NAME = "app_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, AppDataBase::class.java, APP_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideAppDao(db: AppDataBase) = db.criptosDao()

    @Singleton
    @Provides
    fun provideTickerDao(db: AppDataBase) = db.getTickerDao()

    @Singleton
    @Provides
    fun provideOrderBooksDao(db: AppDataBase) = db.getOrderBooksDao()
}