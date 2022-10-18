package com.example.criptobenjaespi.data.repository.mappers

import com.example.criptobenjaespi.data.local.model.AvailableBookEntity
import com.example.criptobenjaespi.data.remote.model.AvailableBookNetwork
import com.example.criptobenjaespi.data.repository.model.CriptoList


fun List<AvailableBookEntity>.toModels(): List<CriptoList> {
    return map { it.toModel() }

}

fun AvailableBookEntity.toModel(): CriptoList {
    return CriptoList(
        book = book,
        maximumAmount = maximum_amount,
        maximumPrice = maximum_price,
        maximumValue = maximum_value,
        minimumPrice = minimum_price,
        criptoType = cripto_type
    )
}

fun AvailableBookEntity.toNetworkModel() = AvailableBookNetwork(
    this.book,
    this.maximum_amount,
    this.maximum_price,
    this.maximum_value,
    this.minimum_price,
    this.cripto_type
)

fun AvailableBookNetwork.toEntity(): AvailableBookEntity = AvailableBookEntity(
    this.book,
    this.maximum_amount,
    this.maximum_price,
    this.maximum_value,
    this.minimum_price,
    this.cripto_type
)


fun AvailableBookNetwork.toModel(): CriptoList = CriptoList(
    book = book,
    maximumAmount = maximum_amount,
    maximumPrice = maximum_price,
    maximumValue = maximum_value,
    minimumPrice = minimum_price,
    criptoType = cripto_type
)