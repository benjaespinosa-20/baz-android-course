package com.example.criptobenjaespi.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.criptobenjaespi.data.local.model.AsksBidsEntity
import com.example.criptobenjaespi.data.local.model.AvailableBookEntity
import com.example.criptobenjaespi.data.local.model.OrderBooksEntity
import com.example.criptobenjaespi.data.local.model.TickerDetailEntity

@Database(entities = [AvailableBookEntity::class, TickerDetailEntity::class, OrderBooksEntity::class, AsksBidsEntity::class], version = 3)
abstract class AppDataBase: RoomDatabase() {

    abstract fun getTickerDao(): TickerDao

    abstract fun criptosDao(): AvailableBookDao

    companion object {
        const val NAMEDATABASE :String = "cripto.db"
    }

    abstract fun getOrderBooksDao(): OrderBookDao

}