package com.example.criptobenjaespi.data.local

import com.example.criptobenjaespi.CriptoBenjaEspiApplication
import com.example.criptobenjaespi.data.local.model.*
import javax.inject.Inject

class LocalCriptoDataSource @Inject constructor() {
    fun getCriptoList(): List<AvailableBookEntity> {
        return CriptoBenjaEspiApplication.getDataBase().criptosDao().getCriptosList()
    }

    fun saveCripto(list: List<AvailableBookEntity>){
        CriptoBenjaEspiApplication.getDataBase().criptosDao().saveCriptos(list)
    }

    fun getTicker(book: String): TickerDetailEntity{
        return CriptoBenjaEspiApplication.getDataBase().getTickerDao().getTicker(book)
    }

    fun saveTicker(ticker: TickerDetailEntity){
        CriptoBenjaEspiApplication.getDataBase().getTickerDao().saveTicker(ticker)
    }

    fun saveOrderBooks(book: OrderBooksEntity): Long = CriptoBenjaEspiApplication.getDataBase().getOrderBooksDao().saveOrderBooks(book)


    fun deleteOrderBooks(name: String) {
        CriptoBenjaEspiApplication.getDataBase().getOrderBooksDao().delete(name)
    }

    fun saveAllAskBids(asksBidsEntity: List<AsksBidsEntity>){
        CriptoBenjaEspiApplication.getDataBase().getOrderBooksDao().saveAllAskBids(asksBidsEntity)
    }

    fun deleteAskBids(book: String, orderBookId: String){
        CriptoBenjaEspiApplication.getDataBase().getOrderBooksDao().deleteAllAskBids(book,orderBookId)
    }

    fun getOrderBooks(books: String): OrderBookWithAsksBidsEntity =
        CriptoBenjaEspiApplication.getDataBase().getOrderBooksDao().getOrderBooksByName(books)




}