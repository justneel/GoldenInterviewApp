package com.neel.ia.data

import com.google.gson.annotations.SerializedName

data class Movie(
    private val id: Int,
    val poster_path: String,
    @SerializedName("original_title")
    val originalTitle: String)