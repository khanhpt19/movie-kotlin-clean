package com.example.movie_kotlin_clean.di

import com.example.movie_kotlin_clean.ui.screen.MainActivityViewModel
import com.example.movie_kotlin_clean.ui.screen.detail.DetailViewModel
import com.example.movie_kotlin_clean.ui.screen.favorite.FavoriteViewModel
import com.example.movie_kotlin_clean.ui.screen.main.MainViewModel
import com.example.movie_kotlin_clean.ui.screen.popular.PopularViewModel
import org.koin.androidx.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel<MainActivityViewModel>()
    viewModel<MainViewModel>()
    viewModel<PopularViewModel>()
    viewModel<FavoriteViewModel>()
    viewModel<DetailViewModel>()
}
