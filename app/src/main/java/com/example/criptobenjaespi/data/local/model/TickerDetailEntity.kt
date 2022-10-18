package com.example.criptobenjaespi.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "ticker_detail")
data class TickerDetailEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "book") val book: String = "",
    @ColumnInfo(name = "volume") val volume: String = "",
    @ColumnInfo(name = "hight") val hight: String = "",
    @ColumnInfo(name = "last") val last: String = "",
    @ColumnInfo(name = "low") val low: String = "",
)