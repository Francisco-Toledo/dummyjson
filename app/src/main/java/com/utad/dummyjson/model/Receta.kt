package com.utad.dummyjson.model

import android.os.Parcelable


@Parcelize
data class Receta(
    @SerializedName("recipes") val recipes: List<DatosReceta>
): Parcelable