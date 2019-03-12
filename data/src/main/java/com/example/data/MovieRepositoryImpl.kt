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
    override fun getMoviesApi(hashMap: HashMap<String, String>): Single<List<Movie>> {
        return movieApi.getMoviesApi().map { response ->
            response.results?.map {
                movieEntityMapper.mapToDomain(it)
            }
        }
    }

    override fun getMovieDetail(id: String): Single<Movie> {
        return movieApi.getMovieDetail(id).map { movieEntityMapper.mapToDomain(it) }
    }

}
