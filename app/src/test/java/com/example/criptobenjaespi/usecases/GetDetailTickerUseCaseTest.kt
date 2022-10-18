package com.example.criptobenjaespi.usecases

import com.example.criptobenjaespi.data.repository.CriptoRepository
import com.example.criptobenjaespi.data.repository.model.DetailTicker
import io.mockk.*
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class GetDetailTickerUseCaseTest{

    @RelaxedMockK
    @MockK
    private lateinit var criptoRepository: CriptoRepository

    lateinit var getDetailTickerUseCase: GetDetailTickerUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getDetailTickerUseCase = GetDetailTickerUseCase(criptoRepository)
    }

    @Test
    fun `validacion de una ejecucion correcta de GetDetailTickerUseCase`() = runBlocking {

        //Given
        val tickerTest = DetailTicker("xrp_mxn", "38","9","8", "7")

        coEvery { criptoRepository.getDetailTicker("xrp_mxn")} returns tickerTest
        //When
        val rBook = getDetailTickerUseCase("xrp_mxn")?.book?.isNotEmpty()
        //Then
        assert(rBook == tickerTest.book.isNotEmpty())

    }
}