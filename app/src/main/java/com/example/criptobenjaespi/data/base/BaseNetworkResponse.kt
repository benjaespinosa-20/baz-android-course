package com.example.criptobenjaespi.data.base

data class BaseNetworkResponse<T>(
    val success: Boolean,
    val payload: T? = null,
    val error: ErrorResponse? = null
)

data class ErrorResponse(
    val message: String,
    val code: String
)