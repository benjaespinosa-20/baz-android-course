package com.example.criptobenjaespi.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.criptobenjaespi.core.Resource
import com.example.criptobenjaespi.data.repository.model.OrderBooksModel
import com.example.criptobenjaespi.usecases.GetDetailTickerUseCase
import com.example.criptobenjaespi.usecases.GetOrderBookUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class CriptoTickerViewModel @Inject constructor(
    private val getDetailTickerUseCase: GetDetailTickerUseCase,
    private val getOrderBookUseCase: GetOrderBookUseCase
): ViewModel() {
    var orderBooksModel: OrderBooksModel? = null
    fun fetchCriptoTicker(book: String) = liveData(Dispatchers.IO){
        Log.d("CriptoTickerViewModel", "call use case")
        emit(Resource.Loading())
        try {
            val response = getDetailTickerUseCase(book)
            when(response != null){
                true -> emit(Resource.Succes(response))
                false -> emit(Resource.Failure(java.lang.Exception("Ticker nulo")))
            }
        }catch (e: Exception){
            Log.e("CriptoTickerViewModel", "failure call use case")
            emit(Resource.Failure(e))
        }

    }

    fun fetchOrderBook(book: String) = liveData(Dispatchers.IO){
        Log.d("CriptoTickerViewModel", "call use case")
        emit(Resource.Loading())
        try {
            val response = getOrderBookUseCase(book)
            when(response != null){
                true -> {
                    orderBooksModel = response
                    emit(Resource.Succes(response))
                }
                false -> emit(Resource.Failure(java.lang.Exception("Ticker nulo")))
            }
        }catch (e: Exception){
            Log.e("CriptoTickerViewModel", "failure call use case")
            emit(Resource.Failure(e))
        }

    }
}