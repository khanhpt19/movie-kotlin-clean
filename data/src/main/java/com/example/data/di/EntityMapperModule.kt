package com.example.data.di

import com.example.data.model.MovieEntityMapper
import org.koin.dsl.module.module
import org.koin.experimental.builder.single

val entityMapperModule = module {
    single<MovieEntityMapper>()
}
