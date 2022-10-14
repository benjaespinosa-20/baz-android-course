package com.example.criptobenjaespi.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//room
@Entity(tableName = "available_book")
data class AvailableBookEntity(
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