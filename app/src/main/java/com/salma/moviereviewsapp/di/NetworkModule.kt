package com.salma.moviereviewsapp.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.salma.moviereviewsapp.BuildConfig
import com.salma.moviereviewsapp.data.remote.NytApi
import com.salma.moviereviewsapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@ExperimentalSerializationApi
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .addInterceptor {
                val url = it.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("api-key", BuildConfig.API_KEY)
                    .build()
                val requestBuilder = it.request().newBuilder()
                    .url(url)
                it.proceed(requestBuilder.build())
            }
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideUnsplashApi(retrofit: Retrofit): NytApi {
        return retrofit.create(NytApi::class.java)
    }
}