package com.salma.moviereviewsapp.data.local

import androidx.room.Dao
import androidx.room.Query
import com.salma.moviereviewsapp.model.Movie
import com.salma.moviereviewsapp.util.Constants
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Query("SELECT * FROM ${Constants.MOVIE_TABLE}")
    fun getMovies(): Flow<List<Movie>>

    @Query("SELECT * FROM ${Constants.MOVIE_TABLE} WHERE id = :id")
    suspend fun getMovieById(id: Int): Movie
}