package com.example.criptobenjaespi.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.criptobenjaespi.core.Resource
import com.example.criptobenjaespi.repository.CriptoRepository
import kotlinx.coroutines.Dispatchers

class CriptoViewModel(private val repo:CriptoRepository): ViewModel() {
    fun fetchCriptoList() = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            emit(Resource.Succes(repo.getCriptoList("_mxn")))
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }
}

class CriptoViewModelFactory(private val repo: CriptoRepository): ViewModelProvider.Factory{
    override fun <T:ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(CriptoRepository::class.java).newInstance(repo)
    }
}