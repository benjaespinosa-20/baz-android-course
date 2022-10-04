package com.example.criptobenjaespi.repository

import com.example.criptobenjaespi.data.model.CriptoList
import com.example.criptobenjaespi.utils.AppConstans
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface WebService{
    @GET("available_books/")
    suspend fun getCriptoList(): CriptoList
}
