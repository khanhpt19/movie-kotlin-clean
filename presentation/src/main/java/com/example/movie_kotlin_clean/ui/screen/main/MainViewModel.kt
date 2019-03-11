package com.example.movie_kotlin_clean.ui.screen.main

import androidx.lifecycle.MutableLiveData
import com.example.domain.usecase.movie.GetMoviesUseCase
import com.example.movie_kotlin_clean.model.MovieItem
import com.example.movie_kotlin_clean.model.MovieItemMapper
import com.example.movie_kotlin_clean.rx.SchedulerProvider
import com.example.movie_kotlin_clean.ui.base.BaseViewModel

class MainViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val schedulerProvider: SchedulerProvider,
    private val movieItemMapper: MovieItemMapper
) : BaseViewModel() {
    val movie = MutableLiveData<MovieItem>()

    fun start() {
        val hashMap = HashMap<String, String>()
        compositeDisposable.add(
            getMoviesUseCase.createObservable(GetMoviesUseCase.Params(hashMap))
                .subscribeOn(schedulerProvider.io())
                .map {
                    it.map {
                        movieItemMapper.mapToPresentation(it)
                    }
                }
                .observeOn(schedulerProvider.ui())
                .subscribe({
                    it.map {
                        movie.value = it
                    }
                }, {
                    errorMessage.value = it.message
                })
        )
    }
}
