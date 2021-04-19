package com.neel.ia.data

data class MoviesList(
    val page: Int,
    val results: List<Movie>,
    val totalResults: Int,
    val totalPages: Int
)