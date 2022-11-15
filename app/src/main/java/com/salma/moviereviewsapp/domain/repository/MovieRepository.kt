package com.salma.moviereviewsapp.domain.repository

import com.salma.moviereviewsapp.domain.model.Movie

import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun refreshMovies()
    fun getAllMovies(): Flow<List<Movie>>
}