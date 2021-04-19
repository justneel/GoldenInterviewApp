package com.neel.ia.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.neel.ia.api.Api
import com.neel.ia.data.MoviesList
import kotlinx.coroutines.Dispatchers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MoviesRepository @Inject constructor(private val api: Api) {

    fun getPopularMovies(): LiveData<MoviesList> {
        return liveData(Dispatchers.IO) {
            val response = api.getPopularMovies().execute()
            if (response.isSuccessful) {
                emit(response.body()!!)
            } else {
                TODO("Handle error")
            }
        }

    }

    private fun refreshPopularMovies() {

    }

    companion object {
        private val POPULAR_MOVIES_TIMEOUT = TimeUnit.DAYS.toMillis(1)
    }
}