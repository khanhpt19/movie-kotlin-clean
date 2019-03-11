package com.example.movie_kotlin_clean.di

import com.example.movie_kotlin_clean.model.MovieItemMapper
import org.koin.dsl.module.module
import org.koin.experimental.builder.single

val itemMapperModule = module {
    single<MovieItemMapper>()
}
