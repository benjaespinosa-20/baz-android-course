package com.example.criptobenjaespi.data.remote

import com.example.criptobenjaespi.data.model.CriptoList
import com.example.criptobenjaespi.repository.WebService

class CriptoDataSource(private val webservice: WebService) {

    suspend fun getCriptoList(): CriptoList = webservice.getCriptoList()

}