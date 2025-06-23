package com.utad.dummyjson.model

import retrofit2.http.GET
import retrofit2.http.Path

interface RecetaApiService {

    @GET("recipes/{recipes}")
    suspend fun getRecipeByDifficulty(
        @Path("difficulty") difficulty: String
    ): List<Receta>

    @GET("recipes/{id}")
    suspend fun getRecipeById(
        @Path("id") id: Int
    ): Receta
}


