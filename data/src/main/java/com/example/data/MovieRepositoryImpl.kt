package com.example.data

import com.example.data.model.MovieEntityMapper
import com.example.data.remote.api.MovieApi
import com.example.domain.model.Movie
import com.example.domain.repository.MovieRepository
import io.reactivex.Single

class MovieRepositoryImpl constructor(
    private val movieApi: MovieApi,
    private val movieEntityMapper: MovieEntityMapper
) : MovieRepository {
    override fun getMoviesApi(type: String, fromServer: Boolean): Single<Movie> {
        return movieApi.getMoviesApi().map { movieEntityMapper.mapToDomain(it) }
    }

}
