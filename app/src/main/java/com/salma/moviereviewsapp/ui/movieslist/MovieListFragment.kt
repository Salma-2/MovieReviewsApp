package com.salma.moviereviewsapp.ui.movieslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.salma.moviereviewsapp.databinding.FragmentMovieListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieListFragment() : Fragment() {

    val viewModel by viewModels<MovieListViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val binding = FragmentMovieListBinding.inflate(inflater)
        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        val adapter = MovieListAdapter(MovieListAdapter.OnClickListener { movie ->
            findNavController().navigate(
                MovieListFragmentDirections.actionMovieListFragmentToMovieDetailsFragment(movie))
        })

        binding.movieRv.adapter = adapter

        return binding.root
    }
}