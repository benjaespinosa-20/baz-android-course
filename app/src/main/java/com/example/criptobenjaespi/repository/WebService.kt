package com.example.criptobenjaespi.repository

import com.example.criptobenjaespi.data.model.CriptoList
import com.example.criptobenjaespi.data.model.DetailTicker
import retrofit2.http.GET
import retrofit2.http.Path

interface WebService{
    @GET("available_books/")
    suspend fun getCriptoList(): CriptoList

    @GET("ticker/?book={book}")
    suspend fun getCriptoTicker(@Path("book") book: String): DetailTicker
}
