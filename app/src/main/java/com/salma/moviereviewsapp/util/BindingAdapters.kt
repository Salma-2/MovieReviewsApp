package com.salma.moviereviewsapp.util

import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.salma.moviereviewsapp.R
import com.salma.moviereviewsapp.domain.model.Movie
import com.salma.moviereviewsapp.domain.model.MovieMultimedia
import com.salma.moviereviewsapp.ui.movieslist.MovieListAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("loadData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Movie>?) {
    data?.let {
        val adapter = recyclerView.adapter as MovieListAdapter
        adapter.submitList(data)
    }
}

@BindingAdapter("setRating")
fun bindRatingTextView(textView: TextView, rating: String) {
    val context = textView.context
    if (rating == "") {
        textView.text = context.getString(R.string.no_rating)
    } else {
        textView.text = rating
    }
}

@BindingAdapter("setImage")
fun bindMovieImage(imageView: ImageView, img: MovieMultimedia) {
    val context = imageView.context
    Picasso.get()
        .load(img.imgUrl)
        .placeholder(AppCompatResources.getDrawable(context, R.drawable.placeholder)!!)
        .noFade()
        .into(imageView)
    imageView.contentDescription = "an image for the movie"
}