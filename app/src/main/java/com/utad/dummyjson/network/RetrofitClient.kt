package com.utad.dummyjson.network

import com.utad.dummyjson.model.RecetaApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    // Puedes cambiar la URL base fácilmente desde aquí
    private const val BASE_URL = "https://dummyjson.com/recipes"

    val api: RecetaApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RecetaApiService::class.java)


    }
}