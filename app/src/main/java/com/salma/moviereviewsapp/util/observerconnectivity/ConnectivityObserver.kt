package com.salma.moviereviewsapp.util.observerconnectivity

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {
    fun observe(): Flow<Status>

    enum class Status{
        Available, Unavailable
    }
}