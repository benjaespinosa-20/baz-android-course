package com.example.criptobenjaespi.usecases

import com.example.criptobenjaespi.data.repository.CriptoRepository
import com.example.criptobenjaespi.data.repository.model.OrderBooksModel
import javax.inject.Inject

class GetOrderBookUseCase @Inject constructor(private val criptoRepository: CriptoRepository) {
    suspend operator fun invoke(book: String): OrderBooksModel? {
        return try {
            criptoRepository.getOrderBooks(book)
        } catch (e: Exception) {
            null
        }
    }
}