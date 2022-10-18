package com.example.criptobenjaespi.data.repository

import android.util.Log
import com.example.criptobenjaespi.data.local.LocalCriptoDataSource
import com.example.criptobenjaespi.data.local.model.*
import com.example.criptobenjaespi.data.repository.mappers.toModels
import com.example.criptobenjaespi.data.repository.mappers.toEntity
import com.example.criptobenjaespi.data.remote.CriptoDataSource
import com.example.criptobenjaespi.data.repository.mappers.toEntities
import com.example.criptobenjaespi.data.repository.mappers.toModel
import com.example.criptobenjaespi.data.repository.model.CriptoList
import com.example.criptobenjaespi.data.repository.model.DetailTicker
import com.example.criptobenjaespi.data.repository.model.OrderBooksModel
import javax.inject.Inject

class CriptoRepositoryImpl @Inject constructor(
    private val dataSource: CriptoDataSource,
    private val dataSourcelocal: LocalCriptoDataSource
) : CriptoRepository {

    override suspend fun getListCriptoFilterByBook(book: String): List<CriptoList> {
        return try {
            val networkResponse = dataSource.getCriptoList().payload
            val books = networkResponse ?: emptyList()
            val booksFilter = books.filter { item -> item.book.contains(book) }

            saveAvailableBookToLocal(booksFilter.map { it.toEntity() })
            booksFilter.map { it.toModel() }

        } catch (e: Exception) {
            getAvailableBooksFromLocal().toModels()
        }
    }

    private fun saveAvailableBookToLocal(books: List<AvailableBookEntity>) {
        try {
            dataSourcelocal.saveCripto(books)
        } catch (e: Exception) {
            Log.e("ErrorDataBase", "No se guardaron datos en local \n error: ${e.message}")
        }
    }

    private fun getAvailableBooksFromLocal(): List<AvailableBookEntity> {
        return try {
            dataSourcelocal.getCriptoList()
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getDetailTicker(book: String): DetailTicker {
        return try {
            Log.d("getDetailTicker", "call service")
            val networkResponse =
                dataSource.getCriptoTicker(book).payload ?: throw Exception("respuesta nula")

            saveTickerToLocal(networkResponse.toEntity())
            networkResponse.toModel()

        } catch (e: Exception) {
            Log.d("getDetailTicker", "failure call service \n error: ${e.message}")
            getTickerFromLocal(book)?.toModel() ?: throw Exception("respuesta nula")
        }

    }

    private fun saveTickerToLocal(ticker: TickerDetailEntity) {
        try {
            dataSourcelocal.saveTicker(ticker)
        } catch (e: Exception) {
            Log.e(
                "ErrorDataBase",
                "saveTickerToLocal: No se guardaron datos en local \n error: ${e.message}"
            )
        }
    }

    private fun getTickerFromLocal(book: String): TickerDetailEntity? {
        return try {
            dataSourcelocal.getTicker(book)
        } catch (e: Exception) {
            Log.e(
                "ErrorDataBase",
                "getTickerFromLocal: No se guardaron datos en local \n error: ${e.message}"
            )
            null
        }
    }

    override suspend fun getOrderBooks(book: String): OrderBooksModel {

        return try {
            val networkResponse = dataSource.getOrderBooks(book).payload ?: throw Exception("Datos nulos")
            val orderBookEntity = networkResponse.toEntity(book)
            Log.d("orderBookEntity", "orderBookEntity: ${orderBookEntity.id}, ${orderBookEntity.name} ")
            val orderBookId = saveOrderBookFromRoom(orderBookEntity)
            orderBookId?.let {
                Log.d("orderBookId", "orderBookId = $orderBookId, book: $book ")
                val asks = (networkResponse.asks).toEntities(orderBookId, 1)
                val bids = (networkResponse.bids).toEntities(orderBookId, 2)
                val askBids = asks.plus(bids)
                Log.e("getOrderBooks", "askBids = [${askBids.first() .id}, ${askBids.first() .orderBookId}, ${askBids.first() .type}, ${askBids.first() .book}]")
                saveAskBidsFromRoom(
                    askBids = askBids,
                    book = book,
                    orderBookId = orderBookId.toString()
                )
            }
            Log.d("getOrderBooks", "success ")
            networkResponse.toModel()
        } catch (e: Exception) {
            Log.d("getOrderBooks", "failure call service error: ${e.message}")
            getOrderBooksToRoom(book)?.toModel() ?: throw Exception("Datos nulos")
        }
    }

    private fun getOrderBooksToRoom(name: String): OrderBookWithAsksBidsEntity? {
        return try {
            Log.d("getOrderBooksToRoom", "get name: $name ")
            val localResponse = dataSourcelocal.getOrderBooks(name)
            Log.d("getOrderBooksToRoom", "get data: $localResponse ")
            localResponse
        } catch (e: Exception) {
            Log.d(
                "getOrderBooksToRoom",
                "getOrderBooksToRoom failure call service error: ${e.message}"
            )
            null
        }
    }

    private fun saveOrderBookFromRoom(book: OrderBooksEntity): Long? {
        return try {
            Log.d("saveOrderBookFromRoom", "name: ${book.name}")
            dataSourcelocal.deleteOrderBooks(book.name)
            dataSourcelocal.saveOrderBooks(book)
        } catch (e: Exception) {
            Log.d(
                "saveOrderBookFromRoom",
                "saveOrderBookFromRoom failure call service error: ${e.message}"
            )
            null
        }
    }


    private fun saveAskBidsFromRoom(
        askBids: List<AsksBidsEntity>,
        book: String,
        orderBookId: String
    ) {
        try {
            dataSourcelocal.deleteAskBids(book, orderBookId)
            dataSourcelocal.saveAllAskBids(askBids)
        } catch (e: Exception) {
            Log.d(
                "saveAskBidsFromRoom",
                "saveAskBidsFromRoom failure call service error: ${e.message}"
            )
        }
    }


}

