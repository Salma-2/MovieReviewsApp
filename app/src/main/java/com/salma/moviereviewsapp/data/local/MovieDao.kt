package com.salma.moviereviewsapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.salma.moviereviewsapp.domain.model.Movie
import com.salma.moviereviewsapp.util.Constants
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Query("SELECT * FROM ${Constants.MOVIE_TABLE}")
    fun getMovies(): Flow<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(movies: List<Movie>)

}