package com.example.criptobenjaespi.repository

import com.example.criptobenjaespi.data.local.LocalCriptoDataSource
import com.example.criptobenjaespi.data.model.CriptoList
import com.example.criptobenjaespi.data.model.DetailTicker
import com.example.criptobenjaespi.data.model.toPayloadEntity
import com.example.criptobenjaespi.data.remote.CriptoDataSource
import javax.inject.Inject

class CriptoRepositoryImpl @Inject constructor(
    private val dataSource: CriptoDataSource,
    private val dataSourcelocal: LocalCriptoDataSource
    ): CriptoRepository{

    override suspend fun getListCripto(): CriptoList = dataSource.getCriptoList()

    override suspend fun getListCriptoFilterByBook(book: String): CriptoList {
        val currentList = dataSource.getCriptoList()
        val filterList = currentList.copy(
            payload = currentList.payload.filter { item -> item.book.contains(book) }
        )
        filterList.payload.forEach{payload ->
            dataSourcelocal.saveCripto(payload.toPayloadEntity())
        }

        return dataSourcelocal.getCriptoList()
    }

    override suspend fun getDetailTicker(book: String): DetailTicker = dataSource.getCriptoTicker(book)


}

