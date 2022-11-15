package com.salma.moviereviewsapp.data.remote


import com.salma.moviereviewsapp.util.Constants
import retrofit2.http.GET
import com.salma.moviereviewsapp.model.ApiResponse


interface NytApi {
    @GET(Constants.REVIEWS_URL)
    suspend fun getMovies(): ApiResponse
}