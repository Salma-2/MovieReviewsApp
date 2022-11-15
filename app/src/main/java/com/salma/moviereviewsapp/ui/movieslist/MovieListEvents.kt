package com.salma.moviereviewsapp.ui.movieslist

import com.salma.moviereviewsapp.domain.model.Movie

sealed class MovieListEvents {
    data class OnMovieClick(val movie: Movie) : MovieListEvents()
}
