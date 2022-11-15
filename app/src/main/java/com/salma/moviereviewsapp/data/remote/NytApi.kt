package com.salma.moviereviewsapp.data.remote


import com.salma.moviereviewsapp.util.Constants
import retrofit2.http.GET
import com.salma.moviereviewsapp.domain.model.ApiResponse


interface NytApi {
    @GET(Constants.REVIEWS_ENDPOINT)
    suspend fun getMovies(): ApiResponse
}