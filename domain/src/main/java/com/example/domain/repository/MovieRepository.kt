package com.example.domain.repository

import com.example.domain.model.Movie
import com.example.domain.repository.base.Repository
import io.reactivex.Single

interface MovieRepository : Repository {
    fun getMovieDetail(id: String): Single<Movie>

    fun getMoviesApi(fromServer: Boolean, page: Int?): Single<List<Movie>>
}
