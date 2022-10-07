package com.example.criptobenjaespi.repository

import com.example.criptobenjaespi.data.model.CriptoList
import com.example.criptobenjaespi.data.model.toPayloadEntity
import com.example.criptobenjaespi.data.remote.CriptoDataSource

class CriptoRepositoryImpl(
    private val dataSource: CriptoDataSource,
    //private val localDataSource: LocalCriptoDataSource
): CriptoRepository {
    override suspend fun getCriptoList(book: String): CriptoList {
        val currentList = dataSource.getCriptoList()
        val filterList = currentList.copy(
            payload = currentList.payload.filter { item -> item.book.contains(book) }
        )

//        filterList.payload.forEach{cripto ->
//            localDataSource.saveCripto(cripto.toPayloadEntity())
//        }

        return filterList

    }
}