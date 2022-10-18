package com.example.criptobenjaespi.presentation

import com.example.criptobenjaespi.data.repository.CriptoRepository
import com.example.criptobenjaespi.usecases.GetDetailTickerUseCase
import com.example.criptobenjaespi.usecases.GetListCriptoByBookUseCase
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

class CriptoViewModelTest{

    @RelaxedMockK
    private lateinit var getListCriptoByBookUseCase: GetListCriptoByBookUseCase

    private lateinit var criptoViewModel: CriptoViewModel

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        criptoViewModel = CriptoViewModel(getListCriptoByBookUseCase)
    }
}