package com.example.criptobenjaespi.data.remote

import com.example.criptobenjaespi.data.base.BaseNetworkResponse
import com.example.criptobenjaespi.data.remote.model.AvailableBookNetwork
import com.example.criptobenjaespi.data.remote.model.DetailTickerNetworkModel
import com.example.criptobenjaespi.data.remote.model.OrderBookNetworkModel
import com.example.criptobenjaespi.data.repository.WebService
import javax.inject.Inject

interface CriptoDataSource {
    suspend fun getCriptoList(): BaseNetworkResponse<List<AvailableBookNetwork>>
    suspend fun getCriptoTicker(book: String): BaseNetworkResponse<DetailTickerNetworkModel>
    suspend fun getOrderBooks(book: String): BaseNetworkResponse<OrderBookNetworkModel>
}

class CriptoDataSourceImpl @Inject constructor(private val webService: WebService) :
    CriptoDataSource {

    override suspend fun getCriptoList(): BaseNetworkResponse<List<AvailableBookNetwork>> =
        webService.getCriptoList()

    override suspend fun getCriptoTicker(book: String): BaseNetworkResponse<DetailTickerNetworkModel> =
        webService.getCriptoTicker(book)

    override suspend fun getOrderBooks(book: String): BaseNetworkResponse<OrderBookNetworkModel> =
        webService.getOrderBook(book)


}

