package com.salma.moviereviewsapp.util

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.salma.moviereviewsapp.R
import com.salma.moviereviewsapp.model.Movie
import com.salma.moviereviewsapp.movieslist.MovieListAdapter

@BindingAdapter("loadData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Movie>?){
    data?.let {
        val adapter = recyclerView.adapter as MovieListAdapter
        adapter.submitList(data)
    }
}

@BindingAdapter("setRating")
fun bindRatingTextView(textView: TextView, rating: String){
    if (rating == ""){
        textView.text= "No Rating"
    }
    else{
        textView.text = rating
    }
}