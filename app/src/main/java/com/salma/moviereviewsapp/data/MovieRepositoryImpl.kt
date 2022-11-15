package com.salma.moviereviewsapp.data

import com.salma.moviereviewsapp.data.local.MovieDao
import com.salma.moviereviewsapp.data.remote.NytApi
import com.salma.moviereviewsapp.model.Movie
import com.salma.moviereviewsapp.model.Response
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl(
    private val dao: MovieDao,
    private val api: NytApi,
) : MovieRepository {

    override suspend fun refreshMovies() {
        val movies = api.getMovies()
        dao.insertAll(movies.results)
    }

    override fun getAllMovies(): Flow<List<Movie>> {
        return dao.getMovies()
    }
}