package com.neel.ia.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.neel.ia.R
import com.neel.ia.data.Movie
import com.squareup.picasso.Picasso
import javax.inject.Inject

class MovieListingAdapter @Inject constructor(private val picasso: Picasso): RecyclerView.Adapter<MovieListingAdapter.MovieListingViewHolder>() {
    private lateinit var movies: List<Movie>

    fun setMovies(movies: List<Movie>) {
        this.movies = movies;
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListingViewHolder {
        return MovieListingViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_listing, parent, false),
            picasso
        )
    }

    override fun onBindViewHolder(holder: MovieListingViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int {
        return if (::movies.isInitialized) {
            movies.size
        } else {
            0
        }
    }

    class MovieListingViewHolder(view: View, val picasso: Picasso) :  RecyclerView.ViewHolder(view) {
        val imageView: ImageView
        val textSection: TextView

        init {
            imageView = view.findViewById(R.id.image)
            textSection = view.findViewById(R.id.text)
        }

        fun bind(movie: Movie) {
            picasso.load("https://image.tmdb.org/t/p/w500" + movie.poster_path).into(imageView)
            textSection.setText(movie.originalTitle)
        }
    }
}