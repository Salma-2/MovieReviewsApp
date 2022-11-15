package com.salma.moviereviewsapp.moviedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.salma.moviereviewsapp.databinding.FragmentMovieDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding = FragmentMovieDetailsBinding.inflate(inflater)
        val movie = MovieDetailsFragmentArgs.fromBundle(
            requireArguments()).movie
        binding.movie = movie

        return binding.root
    }
}