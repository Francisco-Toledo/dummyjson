package com.utad.dummyjson.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DatosReceta(

@SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("ingredients") val ingredients: List<String>,
    @SerializedName("instructions") val instructions: List<String>,
    @SerializedName("prepTimeMinutes") val prepTimeMinutes: Int,
    @SerializedName("cookTimeMinutes") val cookTimeMinutes: Int,
    @SerializedName("servings") val servings: Int,
    @SerializedName("difficulty") val difficulty: String,
    @SerializedName("cuisine") val cuisine: String,
    @SerializedName("caloriesPerServing") val caloriesPerServing: Int,
    @SerializedName("tags") val tags: List<String>,
    @SerializedName("userId") val userId: Int,
    @SerializedName("image") val image: String,
    @SerializedName("rating") val rating: Double,
    @SerializedName("reviewCount") val reviewCount: Int,
    @SerializedName("mealType") val mealType: List<String>
) : Parcelable