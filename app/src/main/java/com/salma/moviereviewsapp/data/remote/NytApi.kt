package com.salma.moviereviewsapp.data.remote


import com.salma.moviereviewsapp.util.Constants
import retrofit2.http.GET
import com.salma.moviereviewsapp.model.Result


interface NytApi {
    @GET(Constants.REVIEWS_URL)
    //Todo(check if return should be Flow, Response??)
    suspend fun getMovies(): Result
}