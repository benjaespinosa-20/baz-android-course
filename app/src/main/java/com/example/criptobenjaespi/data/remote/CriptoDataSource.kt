package com.example.criptobenjaespi.data.remote

import com.example.criptobenjaespi.data.model.CriptoList
import com.example.criptobenjaespi.repository.WebService

class CriptoDataSource(private val webService: WebService) {

    suspend fun getCriptoList():CriptoList = webService.getCriptoList()

}