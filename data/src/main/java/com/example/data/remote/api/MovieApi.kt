package com.example.data.remote.api

import com.example.data.model.MovieEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface MovieApi {
    @GET("movie/popular")
    fun getMoviesApi(@QueryMap hashMap: HashMap<String, String> = HashMap()): Single<MovieEntity>

    @GET("movie/{id}")
    fun getMovieDetail(@QueryMap hashMap: HashMap<String, String> = HashMap()): Single<MovieEntity>
}
