package com.salma.moviereviewsapp.domain.model


data class ApiResponse(
    val results: List<Movie>,
    val status: String,
)
