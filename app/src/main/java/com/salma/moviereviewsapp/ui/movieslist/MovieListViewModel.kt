package com.salma.moviereviewsapp.ui.movieslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.salma.moviereviewsapp.domain.repository.MovieRepository
import com.salma.moviereviewsapp.domain.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val repository: MovieRepository,
) : ViewModel() {
    val movies: LiveData<List<Movie>> by lazy {
        repository
            .getAllMovies()
            .catch { }
            .asLiveData()
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.refreshMovies()
        }
    }
}