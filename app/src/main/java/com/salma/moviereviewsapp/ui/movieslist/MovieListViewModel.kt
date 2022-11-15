package com.salma.moviereviewsapp.ui.movieslist

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.salma.moviereviewsapp.domain.repository.MovieRepository
import com.salma.moviereviewsapp.domain.model.Movie
import com.salma.moviereviewsapp.util.observerconnectivity.ConnectivityObserver
import com.salma.moviereviewsapp.util.observerconnectivity.NetworkConnectivityObserve
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val repository: MovieRepository,
    private val connectivityObserver: ConnectivityObserver,
) : ViewModel() {

    val movies: LiveData<List<Movie>> by lazy {
        repository
            .getAllMovies()
            .catch { }
            .asLiveData()
    }


    init {

        viewModelScope.launch(Dispatchers.IO) {
            connectivityObserver.observe().collect { status ->
                if (status == ConnectivityObserver.Status.Available)
                    repository.refreshMovies()
            }
        }
    }
}