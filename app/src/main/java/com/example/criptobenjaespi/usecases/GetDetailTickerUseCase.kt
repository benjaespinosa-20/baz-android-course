package com.example.criptobenjaespi.usecases

import com.example.criptobenjaespi.data.model.DetailTicker
import com.example.criptobenjaespi.repository.CriptoRepository
import javax.inject.Inject

class GetDetailTickerUseCase @Inject constructor(private val criptoRepository: CriptoRepository) {
    suspend operator fun invoke(book: String): DetailTicker = criptoRepository.getDetailTicker(book)
}