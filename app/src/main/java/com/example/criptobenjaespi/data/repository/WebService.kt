package com.example.criptobenjaespi.data.repository

import com.example.criptobenjaespi.data.base.BaseNetworkResponse
import com.example.criptobenjaespi.data.remote.model.AvailableBookNetwork
import com.example.criptobenjaespi.data.remote.model.DetailTickerNetworkModel
import com.example.criptobenjaespi.data.remote.model.OrderBookNetworkModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService{
    @GET("available_books/")
    suspend fun getCriptoList(): BaseNetworkResponse<List<AvailableBookNetwork>>

    @GET("ticker/")
    suspend fun getCriptoTicker(@Query("book") book: String): BaseNetworkResponse<DetailTickerNetworkModel>

    @GET("order_book/")
    suspend fun getOrderBook(
        @Query("book") book: String,
        @Query("aggregate") aggregate: Boolean = true
    ): BaseNetworkResponse<OrderBookNetworkModel>
}
