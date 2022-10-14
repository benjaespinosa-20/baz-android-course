package com.example.criptobenjaespi.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import java.util.*

@Entity(tableName = "order_book")
data class OrderBooksEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "update_at")
    val updated_at: String,
    @ColumnInfo(name = "sequence")
    val sequence: String,
)

@Entity(tableName = "askbids")
data class AsksBidsEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "order_book_id")
    val orderBookId: String,
    @ColumnInfo(name = "book")
    val book: String,
    @ColumnInfo(name = "price")
    val price: String,
    @ColumnInfo(name = "amount")
    val amount: String,
    @ColumnInfo(name = "type")
    val type: Int
)

data class OrderBookWithAsksBidsEntity(
    @Embedded
    val orderBooksEntity: OrderBooksEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "order_book_id"
    )
    val askBids: List<AsksBidsEntity>
)