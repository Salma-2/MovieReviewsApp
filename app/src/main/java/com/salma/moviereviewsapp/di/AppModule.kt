package com.salma.moviereviewsapp.di

import com.salma.moviereviewsapp.domain.repository.MovieRepository
import com.salma.moviereviewsapp.domain.repository.MovieRepositoryImpl
import com.salma.moviereviewsapp.data.local.MoviesDatabase
import com.salma.moviereviewsapp.data.remote.NytApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesMovieRepository(db: MoviesDatabase, api: NytApi): MovieRepository {
        return MovieRepositoryImpl(db.dao, api)
    }
}