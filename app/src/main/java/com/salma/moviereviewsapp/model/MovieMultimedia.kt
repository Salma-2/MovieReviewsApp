package com.salma.moviereviewsapp.model
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class MovieMultimedia(
    @SerializedName("src")
    val imgUrl : String
)
