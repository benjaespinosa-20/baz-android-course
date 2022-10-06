package com.example.criptobenjaespi.data.remote

import com.example.criptobenjaespi.data.model.CriptoList
import com.example.criptobenjaespi.data.model.DetailTicker
import com.example.criptobenjaespi.repository.WebService
import javax.inject.Inject

interface CriptoDataSource{
    suspend fun getCriptoList(): CriptoList
    suspend fun getCriptoTicker(book: String) :DetailTicker
}
class CriptoDataSourceImpl @Inject constructor(private val webService: WebService): CriptoDataSource {

    override suspend fun getCriptoList():CriptoList = webService.getCriptoList()
    override suspend fun getCriptoTicker(book: String): DetailTicker = webService.getCriptoTicker(book)

}

