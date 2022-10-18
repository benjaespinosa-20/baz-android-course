package com.example.criptobenjaespi.usecases

import android.graphics.ColorSpace.Model
import com.example.criptobenjaespi.data.repository.CriptoRepository
import com.example.criptobenjaespi.data.repository.model.CriptoList
import com.example.criptobenjaespi.data.repository.model.DetailTicker
import com.example.criptobenjaespi.data.repository.model.OrderBooksModel
import com.google.common.truth.Truth
import io.mockk.*
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GetOrderBookUseCaseTest {
    private val mockCriptoRepository = mockk<CriptoRepository>(relaxed = true)
    @After
    fun tearDown(){
        clearAllMocks()
    }

    @Test
    fun `validacion de una ejecucion exitosa del caso de uso GetOrderBookUseCase`() = runBlocking {
        coEvery { mockCriptoRepository.getOrderBooks(any())} returns OrderBooksModel("3", "5", listOf(), listOf())
        val targetTest = GetOrderBookUseCase(mockCriptoRepository)
        Truth.assertThat(targetTest.invoke(book = "btc_mxn")).isEqualTo(listOf<OrderBooksModel>())
    }
}