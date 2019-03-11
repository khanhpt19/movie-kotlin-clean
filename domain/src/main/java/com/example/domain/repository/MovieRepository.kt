package com.example.domain.repository

import com.example.domain.model.Movie
import com.example.domain.repository.base.Repository
import io.reactivex.Single

interface MovieRepository : Repository {
    fun getMoviesApi(type: String, fromServer: Boolean): Single<Movie>
}
