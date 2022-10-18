package com.example.criptobenjaespi

import android.app.Application
import androidx.room.Room
import com.example.criptobenjaespi.data.local.AppDataBase
import com.example.criptobenjaespi.utils.AppCoreUtil
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CriptoBenjaEspiApplication: Application(){

    companion object{
        var APPLICATION_INSTANCE: CriptoBenjaEspiApplication? = null
        private var databeInstance: AppDataBase? = null

        fun getDataBase():AppDataBase{
            if(databeInstance == null){
                synchronized(AppDataBase::class.java){
                    APPLICATION_INSTANCE?.let {
                        databeInstance = Room.databaseBuilder(it, AppDataBase::class.java, AppDataBase.NAMEDATABASE)
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }

            return databeInstance!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        APPLICATION_INSTANCE = this
        AppCoreUtil.context = applicationContext
    }
}