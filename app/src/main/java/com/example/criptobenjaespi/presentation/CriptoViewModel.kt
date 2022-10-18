package com.example.criptobenjaespi.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.criptobenjaespi.core.Resource
import com.example.criptobenjaespi.usecases.GetListCriptoByBookUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class CriptoViewModel @Inject constructor(
    private val getListCriptoByBookUseCase: GetListCriptoByBookUseCase,
    ):ViewModel() {

    fun fetchCriptoList() = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            val response = getListCriptoByBookUseCase("_mxn")
            emit(Resource.Succes(response))
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }

}

