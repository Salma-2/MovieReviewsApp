package com.salma.moviereviewsapp.model


data class ApiResponse(
    val results: List<Movie>,
    val status: String,
)
