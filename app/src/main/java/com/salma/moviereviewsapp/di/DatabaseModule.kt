package com.salma.moviereviewsapp.di

import android.content.Context
import androidx.room.Room
import com.salma.moviereviewsapp.data.local.MoviesDatabase
import com.salma.moviereviewsapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): MoviesDatabase {
        return Room.databaseBuilder(
            context,
            MoviesDatabase::class.java,
            Constants.MOVIE_Database
        ).build()
    }

}