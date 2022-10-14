package com.example.criptobenjaespi.data.local

import androidx.room.*
import com.example.criptobenjaespi.data.local.model.*

@Dao
interface AvailableBookDao {
    @Query("SELECT * FROM available_book")
    fun getCriptosList(): List<AvailableBookEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCriptos(list: List<AvailableBookEntity>)
}

@Dao
interface TickerDao{
    @Query("SELECT * FROM ticker_detail WHERE book = :book")
    fun getTicker(book: String): TickerDetailEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTicker(ticker: TickerDetailEntity)
}

@Dao
interface OrderBookDao{
    @Transaction
    @Query("SELECT * FROM order_book WHERE name = :name")
    fun getOrderBooksByName(name: String): OrderBookWithAsksBidsEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveOrderBooks(orderBook: OrderBooksEntity): Long

    @Query("DELETE FROM order_book WHERE name = :name")
    fun delete(name: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllAskBids(askBidsList: List<AsksBidsEntity>)

    @Query("DELETE FROM askbids WHERE book = :book AND order_book_id = :OrderBookId")
    fun deleteAllAskBids(book: String, OrderBookId: String)
}