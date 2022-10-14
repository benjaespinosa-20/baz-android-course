package com.example.criptobenjaespi.usecases

import android.util.Log
import com.example.criptobenjaespi.data.remote.model.DetailTickerNetworkModel
import com.example.criptobenjaespi.data.repository.CriptoRepository
import com.example.criptobenjaespi.data.repository.model.DetailTicker
import javax.inject.Inject

class GetDetailTickerUseCase @Inject constructor(private val criptoRepository: CriptoRepository) {
    suspend operator fun invoke(book: String): DetailTicker? {
        return try {
            Log.d("GetDetailTickerUseCase", "call repo")
            criptoRepository.getDetailTicker(book)
        } catch (e: Exception) {
            Log.d("GetDetailTickerUseCase", "failure call repo")
            null
        }
    }
}