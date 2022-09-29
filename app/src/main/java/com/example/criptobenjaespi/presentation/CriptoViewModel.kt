package com.example.criptobenjaespi.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.criptobenjaespi.core.Resource
import com.example.criptobenjaespi.repository.CriptoRepository
import kotlinx.coroutines.Dispatchers

class CriptoViewModel(private val repo: CriptoRepository):ViewModel() {
    //prueba

    fun fetchCriptoList() = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            emit(Resource.Succes(repo.getListCripto()))
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }
}

