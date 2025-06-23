package com.utad.dummyjson.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class Receta(
    @SerializedName("recipes") val recipes: List<DatosReceta>
): Parcelable