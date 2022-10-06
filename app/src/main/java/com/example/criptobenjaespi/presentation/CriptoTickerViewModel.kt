package com.example.criptobenjaespi.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.criptobenjaespi.core.Resource
import com.example.criptobenjaespi.data.model.BookDetail
import com.example.criptobenjaespi.data.model.DetailTicker
import com.example.criptobenjaespi.usecases.GetDetailTickerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class CriptoTickerViewModel @Inject constructor(
    private val getDetailTickerUseCase: GetDetailTickerUseCase,
): ViewModel() {
    fun fetchCriptoTicker(book: String) = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            emit(Resource.Succes(getDetailTickerUseCase(book).bookDetail))
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }

    }
}