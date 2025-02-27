package com.example.criptobenjaespi.repository

import com.example.criptobenjaespi.data.model.CriptoList

interface CriptoRepository {
    suspend fun getListCripto(): CriptoList
    suspend fun getListCriptoFilterByBook(book: String) : CriptoList
}