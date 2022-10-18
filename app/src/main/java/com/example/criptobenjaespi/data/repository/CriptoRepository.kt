package com.example.criptobenjaespi.data.repository

import com.example.criptobenjaespi.data.repository.model.CriptoList
import com.example.criptobenjaespi.data.repository.model.DetailTicker
import com.example.criptobenjaespi.data.repository.model.OrderBooksModel

interface CriptoRepository {
    //suspend fun getListCripto(): CriptoList
    suspend fun getListCriptoFilterByBook(book: String) : List<CriptoList>
    suspend fun getDetailTicker(book: String): DetailTicker

    suspend fun getOrderBooks(book: String): OrderBooksModel
}