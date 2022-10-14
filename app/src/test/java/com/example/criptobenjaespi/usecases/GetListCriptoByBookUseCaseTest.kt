package com.example.criptobenjaespi.usecases

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.criptobenjaespi.data.repository.CriptoRepository
import com.example.criptobenjaespi.data.repository.model.CriptoList
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import com.google.common.truth.Truth.assertThat
import io.mockk.clearAllMocks
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith

class GetListCriptoByBookUseCaseTest{
    private val mockCriptoRepository = mockk<CriptoRepository>(relaxed = true)
    @After
    fun tearDown(){
        clearAllMocks()
    }

    @Test
    fun `validacion de una ejecucion exitosa del caso de uso GetListCriptoByBookUseCase`() = runBlocking {
        coEvery { mockCriptoRepository.getListCriptoFilterByBook(any()) } returns listOf()
        val targetTest = GetListCriptoByBookUseCase(mockCriptoRepository)
        assertThat(targetTest.invoke(book = "cripto")).isEqualTo(listOf<CriptoList>())
    }
}