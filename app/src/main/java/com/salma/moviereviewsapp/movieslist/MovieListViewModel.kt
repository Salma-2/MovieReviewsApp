package com.salma.moviereviewsapp.movieslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.salma.moviereviewsapp.data.MovieRepository
import com.salma.moviereviewsapp.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import com.salma.moviereviewsapp.movieslist.MovieListEvents.OnMovieClick
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val repository: MovieRepository,
) : ViewModel() {
    val movies: LiveData<List<Movie>> = repository
        .getAllMovies()
        .catch { }
        .asLiveData()
}