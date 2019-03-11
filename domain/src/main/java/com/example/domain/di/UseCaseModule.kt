package com.example.domain.di

import com.example.domain.usecase.movie.GetMoviesUseCase
import org.koin.dsl.module.module
import org.koin.experimental.builder.single

val useCaseModule = module {
    single<GetMoviesUseCase>()
}
