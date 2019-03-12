package com.example.data.remote.api

import com.example.data.model.MovieEntity
import com.example.data.remote.response.BaseResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface MovieApi {
    @GET("movie/popular")
    fun getMoviesApi(@QueryMap hashMap: HashMap<String, String> = HashMap()): Single<BaseResponse>

    @GET("movie/{id}")
    fun getMovieDetail(@Path("id") id: String): Single<MovieEntity>
}
