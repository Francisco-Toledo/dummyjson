package com.utad.dummyjson.repository
import com.utad.dummyjson.model.Receta
import com.utad.dummyjson.model.RecetaApiService

class RecetaRepository (
    private val api: RecetaApiService
    ) {

        suspend fun getRecipeByDifficulty(difficulty: String): List<Receta> =
            api.getRecipeByDifficulty(difficulty)

        suspend fun getRecipeById(id: Int): Receta =
            api.getRecipeById(id)
    }

