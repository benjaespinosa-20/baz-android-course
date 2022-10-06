package com.example.criptobenjaespi.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.criptobenjaespi.data.model.PayloadEntity

@Database(entities = [PayloadEntity::class], version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract fun criptosDao(): CriptoDao

    companion object {
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase{
            INSTANCE = INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java,
                "cripto_table"
            ).build()
            return  INSTANCE!!
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }

}