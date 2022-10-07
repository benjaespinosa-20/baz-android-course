package com.example.criptobenjaespi.repository

import com.example.criptobenjaespi.data.model.CriptoList

interface CriptoRepository {
    suspend fun getCriptoList(book: String): CriptoList
}