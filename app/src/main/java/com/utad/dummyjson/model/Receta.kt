package com.utad.dummyjson.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Receta(
    @SerializedName("recipes") val recipes: List<DatosReceta>
): Parcelable