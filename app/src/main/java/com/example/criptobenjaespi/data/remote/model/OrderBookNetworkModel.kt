package com.example.criptobenjaespi.data.remote.model

data class OrderBookNetworkModel(
    val updated_at: String,
    val sequence: String,
    val asks: List<AsksBidsNetworkModelResponse>,
    val bids: List<AsksBidsNetworkModelResponse>
)

data class AsksBidsNetworkModelResponse (
    val book: String,
    val price: String,
    val amount: String
)
