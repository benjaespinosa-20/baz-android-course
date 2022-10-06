package com.example.criptobenjaespi.data.model

data class BookDetail (
    val book: String = "",
    val volume: String = "",
    val hight: String = "",
    val last: String = "",
    val low: String = "",
)

data class DetailTicker(val success: Boolean = true, val bookDetail: BookDetail)