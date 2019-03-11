package com.example.domain.usecase.movie

import com.example.domain.Constants
import com.example.domain.model.Movie
import com.example.domain.repository.MovieRepository
import com.example.domain.usecase.UseCase
import io.reactivex.Single

open class GetMoviesUseCase constructor(
    private val movieRepository: MovieRepository
) : UseCase<GetMoviesUseCase.Params?, Single<Movie>>() {
    override fun createObservable(params: GetMoviesUseCase.Params?): Single<Movie> {
        params?.apply {
            return movieRepository.getMoviesApi(params.type, params.fromServer)
        }
        return Single.error { Throwable(Constants.PARAMS_ERROR) }
    }

    override fun onCleared() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    data class Params(val type: String, val fromServer: Boolean)
}
