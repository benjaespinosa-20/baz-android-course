package com.example.criptobenjaespi.core

sealed class Resource<out T> {
    class Loading<out T>: Resource<T>()
    data class Succes<out T>(val data:T): Resource<T>()
    data class Failure(val exception: Exception): Resource<Nothing>()
}