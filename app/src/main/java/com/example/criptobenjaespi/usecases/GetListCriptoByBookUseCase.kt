package com.example.criptobenjaespi.usecases

import com.example.criptobenjaespi.data.model.CriptoList
import com.example.criptobenjaespi.repository.CriptoRepository
import javax.inject.Inject

class GetListCriptoByBookUseCase @Inject constructor(private val criptoRepository: CriptoRepository) {
    suspend operator fun invoke(book: String): CriptoList = criptoRepository.getListCriptoFilterByBook(book)
}