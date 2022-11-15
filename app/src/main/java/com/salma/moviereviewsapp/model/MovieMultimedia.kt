package com.salma.moviereviewsapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class MovieMultimedia(
    @SerializedName("src")
    val imgUrl: String,
) : Parcelable
