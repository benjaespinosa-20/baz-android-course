package com.example.criptobenjaespi.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Payload(
    val book: String = "",
    val maximum_amount: String= "",
    val maximum_price: String= "",
    val maximum_value: String= "",
    val minimum_price: String= "",
    val cripto_type: String= ""
    )

data class CriptoList(
    val payload: List<Payload> = listOf(),
    val success: Boolean = true
)

//room
@Entity
data class PayloadEntity(
    @PrimaryKey
    val book: String= "",
    @ColumnInfo(name = "maximum_amount")
    val maximum_amount: String= "",
    @ColumnInfo(name = "maximum_price")
    val maximum_price: String= "",
    @ColumnInfo(name = "maximum_value")
    val maximum_value: String= "",
    @ColumnInfo(name = "minimum_price")
    val minimum_price: String= "",
    @ColumnInfo(name = "cripto_type")
    val cripto_type: String= ""
)

fun List<PayloadEntity>.toCriptoList(): CriptoList{
    val resultList = mutableListOf<Payload>()
    this.forEach{ payloadEntity ->
        resultList.add(payloadEntity.toPayload())
    }
    return CriptoList(resultList)
}

fun PayloadEntity.toPayload() = Payload(
    this.book,
    this.maximum_amount,
    this.maximum_price,
    this.maximum_value,
    this.minimum_price,
    this.cripto_type
)

fun Payload.toPayloadEntity(): PayloadEntity = PayloadEntity(
    this.book,
    this.maximum_amount,
    this.maximum_price,
    this.maximum_value,
    this.minimum_price,
    this.cripto_type
)