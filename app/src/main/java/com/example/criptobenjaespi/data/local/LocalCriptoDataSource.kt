package com.example.criptobenjaespi.data.local

import com.example.criptobenjaespi.data.model.CriptoList
import com.example.criptobenjaespi.data.model.PayloadEntity
import com.example.criptobenjaespi.data.model.toCriptoList
import javax.inject.Inject

class LocalCriptoDataSource @Inject constructor(private val criptoDao: CriptoDao) {
    suspend fun getCriptoList(): CriptoList {
        return criptoDao.getCriptosList().toCriptoList()
    }

    suspend fun saveCripto(cripto: PayloadEntity){
        criptoDao.saveCriptos(cripto)
    }
}