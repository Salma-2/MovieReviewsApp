package com.salma.moviereviewsapp.data.remote

import com.salma.moviereviewsapp.model.Movie
import com.salma.moviereviewsapp.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface NytApi {
    @GET(Constants.REVIEWS_URL)
    suspend fun getMovies(): List<Movie>

}