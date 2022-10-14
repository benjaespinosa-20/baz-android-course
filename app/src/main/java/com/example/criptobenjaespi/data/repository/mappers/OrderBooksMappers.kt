package com.example.criptobenjaespi.data.repository.mappers

import com.example.criptobenjaespi.data.local.model.AsksBidsEntity
import com.example.criptobenjaespi.data.local.model.OrderBookWithAsksBidsEntity
import com.example.criptobenjaespi.data.local.model.OrderBooksEntity
import com.example.criptobenjaespi.data.remote.model.AsksBidsNetworkModelResponse
import com.example.criptobenjaespi.data.remote.model.OrderBookNetworkModel
import com.example.criptobenjaespi.data.repository.model.AsksBidsModel
import com.example.criptobenjaespi.data.repository.model.OrderBooksModel

fun OrderBookWithAsksBidsEntity.toModel(): OrderBooksModel{
    return OrderBooksModel(
        updatedAt = orderBooksEntity.updated_at,
        sequence = orderBooksEntity.sequence,
        asks = askBids.toAskModel(),
        bids = askBids.toBidsModel()
    )
}

private fun  List<AsksBidsEntity>.toAskModel(): List<AsksBidsModel> {
    return filter {
        it.type == 1
    }.map {
        AsksBidsModel(
            book = it.book,
            price = it.price,
            amount = it.amount
        )
    }
}

private fun  List<AsksBidsEntity>.toBidsModel(): List<AsksBidsModel> {
    return filter {
        it.type == 2
    }.map {
        AsksBidsModel(
            book = it.book,
            price = it.price,
            amount = it.amount
        )
    }
}

fun  List<AsksBidsNetworkModelResponse>.toEntities(orderBookId: Long, type: Int): List<AsksBidsEntity> {
    return map {
        AsksBidsEntity(
            orderBookId = orderBookId.toString(),
            book = it.book,
            price = it.price,
            amount = it.amount,
            type = type
        )
    }
}

fun OrderBookNetworkModel.toModel(): OrderBooksModel{
    return OrderBooksModel(
        updatedAt = updated_at,
        sequence = sequence,
        asks = asks.map {
            AsksBidsModel(
                book = it.book,
                price = it.price,
                amount = it.amount
            )
        },
        bids = bids.map {
            AsksBidsModel(
                book = it.book,
                price = it.price,
                amount = it.amount
            )
        }
    )
}

fun OrderBookNetworkModel.toEntity(name: String ): OrderBooksEntity {
    return OrderBooksEntity(
        name = name,
        sequence = sequence,
        updated_at = updated_at
    )
}

