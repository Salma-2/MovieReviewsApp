package com.salma.moviereviewsapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.salma.moviereviewsapp.data.local.MovieDao
import com.salma.moviereviewsapp.domain.model.Movie

@Database(
    entities = [Movie::class],
    version = 1
)
abstract class MoviesDatabase : RoomDatabase() {
    abstract val dao: MovieDao
}