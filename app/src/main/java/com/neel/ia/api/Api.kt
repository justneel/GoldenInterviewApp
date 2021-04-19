package com.neel.ia.api

import com.neel.ia.data.MoviesList
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("/3/movie/popular")
    fun getPopularMovies(): Call<MoviesList>
}