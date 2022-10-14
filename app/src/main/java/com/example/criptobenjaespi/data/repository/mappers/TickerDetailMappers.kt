package com.example.criptobenjaespi.data.repository.mappers

import com.example.criptobenjaespi.data.local.model.TickerDetailEntity
import com.example.criptobenjaespi.data.remote.model.DetailTickerNetworkModel
import com.example.criptobenjaespi.data.repository.model.DetailTicker

fun TickerDetailEntity.toModel(): DetailTicker {
    return DetailTicker(
        book = book,
        volume = volume,
        hight = hight,
        last = last,
        low = low,
    )
}

fun DetailTickerNetworkModel.toModel(): DetailTicker {
    return DetailTicker(
        book = book,
        volume = volume,
        hight = high,
        last = last,
        low = low,
    )
}

fun DetailTickerNetworkModel.toEntity(): TickerDetailEntity {
    return TickerDetailEntity(
        book = book,
        volume = volume,
        hight = high,
        last = last,
        low = low,
    )
}