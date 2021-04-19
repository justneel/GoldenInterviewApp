package com.neel.ia

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.neel.ia.adapters.MovieListingAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MovieListingFragment: Fragment() {
    val moviesViewModel: MovieListingViewModel by viewModels()

    @Inject
    lateinit var adapter: MovieListingAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.listing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (getView() as RecyclerView).adapter = adapter
        moviesViewModel.popularMovies.observe(viewLifecycleOwner, {moviesList ->
            if (moviesList != null) {
                adapter.setMovies(moviesList.results)
            } else {
                adapter.setMovies(emptyList())
            }
        })

    }
}