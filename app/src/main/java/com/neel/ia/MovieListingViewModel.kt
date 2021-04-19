package com.neel.ia

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.neel.ia.data.MoviesList
import com.neel.ia.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieListingViewModel @Inject constructor(moviesRepository: MoviesRepository) :
    ViewModel() {
        val popularMovies: LiveData<MoviesList> = moviesRepository.getPopularMovies()
}