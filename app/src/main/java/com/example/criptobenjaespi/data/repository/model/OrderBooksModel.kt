package com.example.criptobenjaespi.data.repository.model

data class OrderBooksModel(
    val updatedAt: String,
    val sequence: String,
    val asks: List<AsksBidsModel>,
    val bids: List<AsksBidsModel>
)

data class AsksBidsModel(
    val book: String,
    val price: String,
    val amount: String
)