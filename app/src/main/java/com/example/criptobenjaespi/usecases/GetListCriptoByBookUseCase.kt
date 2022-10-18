package com.example.criptobenjaespi.usecases

import com.example.criptobenjaespi.data.repository.CriptoRepository
import com.example.criptobenjaespi.data.repository.model.CriptoList
import javax.inject.Inject

class GetListCriptoByBookUseCase @Inject constructor(private val criptoRepository: CriptoRepository) {
    suspend operator fun invoke(book: String): List<CriptoList> = criptoRepository.getListCriptoFilterByBook(book)
}