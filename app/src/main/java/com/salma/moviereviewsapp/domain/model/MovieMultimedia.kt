package com.salma.moviereviewsapp.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class MovieMultimedia(
    @SerializedName("src")
    val imgUrl: String,
    val width: Int,
    val height: Int,
) : Parcelable
