package com.example.criptobenjaespi.repository

import com.example.criptobenjaespi.data.model.CriptoList
import com.example.criptobenjaespi.data.remote.CriptoDataSource
import javax.inject.Inject

class CriptoRepositoryImpl @Inject constructor(private val dataSource: CriptoDataSource): CriptoRepository{

    override suspend fun getListCripto(): CriptoList = dataSource.getCriptoList()

    override suspend fun getListCriptoFilterByBook(book: String): CriptoList {
        val currentList = dataSource.getCriptoList()
        val filterList = currentList.copy(
            payload = currentList.payload.filter { item -> item.book.contains(book) }
        )
        return filterList
    }


}

