package com.example.criptobenjaespi.data.remote.model

import com.example.criptobenjaespi.data.local.model.AvailableBookEntity

data class AvailableBookNetwork(
    val book: String = "",
    val maximum_amount: String= "",
    val maximum_price: String= "",
    val maximum_value: String= "",
    val minimum_price: String= "",
    val cripto_type: String= ""
    )
