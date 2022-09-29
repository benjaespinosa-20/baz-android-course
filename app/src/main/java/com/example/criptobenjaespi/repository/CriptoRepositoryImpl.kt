package com.example.criptobenjaespi.repository

import com.example.criptobenjaespi.data.model.CriptoList
import com.example.criptobenjaespi.data.remote.CriptoDataSource

class CriptoRepositoryImpl(private val dataSource: CriptoDataSource): CriptoRepository{

    override suspend fun getListCripto(): CriptoList = dataSource.getCriptoList()


}

