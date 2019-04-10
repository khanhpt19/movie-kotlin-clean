package com.example.movie_kotlin_clean.ui.screen.popular

import com.example.domain.repository.MovieRepository
import com.example.movie_kotlin_clean.model.MovieItem
import com.example.movie_kotlin_clean.model.MovieItemMapper
import com.example.movie_kotlin_clean.rx.SchedulerProvider
import com.example.movie_kotlin_clean.ui.base.BaseLoadMoreRefreshViewModel

class PopularViewModel(
    val repository: MovieRepository,
    val schedulerProvider: SchedulerProvider,
    val movieItem: MovieItemMapper
) : BaseLoadMoreRefreshViewModel<MovieItem>() {
    override fun loadData(page: Int) {
        addDisposable(
            repository.getMoviesApi(true, page)
                .map {
                    it.map {
                        movieItem.mapToPresentation(it)
                    }
                }
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe({
                    onLoadSuccess(page, it)
                }, {
                    onLoadFail(it)
                })
        )
    }
}
