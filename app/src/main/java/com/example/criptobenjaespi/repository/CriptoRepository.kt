package com.example.criptobenjaespi.repository

import com.example.criptobenjaespi.data.model.CriptoList
import com.example.criptobenjaespi.data.model.DetailTicker

interface CriptoRepository {
    suspend fun getListCripto(): CriptoList
    suspend fun getListCriptoFilterByBook(book: String) : CriptoList
    suspend fun getDetailTicker(book: String): DetailTicker
}