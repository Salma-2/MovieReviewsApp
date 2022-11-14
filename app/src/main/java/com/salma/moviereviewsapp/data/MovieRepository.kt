package com.salma.moviereviewsapp.data

import com.salma.moviereviewsapp.model.Movie
import com.salma.moviereviewsapp.model.Response
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun refreshMovies()
    suspend fun getMovie(id: Int): Movie
    suspend fun getAllMovies(): Flow<List<Movie>>
}