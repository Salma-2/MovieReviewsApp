package com.salma.moviereviewsapp.movieslist

import com.salma.moviereviewsapp.model.Movie

sealed class MovieListEvents {
    data class OnMovieClick(val movie: Movie) : MovieListEvents()
}
