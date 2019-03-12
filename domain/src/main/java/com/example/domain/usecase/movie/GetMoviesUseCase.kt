package com.example.domain.usecase.movie

import com.example.domain.Constants
import com.example.domain.model.Movie
import com.example.domain.repository.MovieRepository
import com.example.domain.usecase.UseCase
import io.reactivex.Single

open class GetMoviesUseCase constructor(
    private val movieRepository: MovieRepository
) : UseCase<GetMoviesUseCase.Params?, Single<List<Movie>>>() {
    override fun createObservable(params: Params?): Single<List<Movie>> {
        params?.apply {
            return movieRepository.getMoviesApi(params.hashMap)
        }
        return Single.error { Throwable(Constants.PARAMS_ERROR) }
    }

    override fun onCleared() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    data class Params(val hashMap: HashMap<String, String>)
}
