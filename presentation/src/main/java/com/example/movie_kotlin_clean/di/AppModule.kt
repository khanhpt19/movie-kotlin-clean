package com.example.movie_kotlin_clean.di

import com.example.data.di.entityMapperModule
import com.example.data.di.networkModule
import com.example.data.di.repositoryModule
import com.example.domain.di.useCaseModule
import com.example.movie_kotlin_clean.rx.AppSchedulerProvider
import com.example.movie_kotlin_clean.rx.SchedulerProvider
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

val appModule = module {
    single { androidApplication().resources }
    single<SchedulerProvider> { AppSchedulerProvider() }
}

val modules = listOf(
    entityMapperModule,
    networkModule,
    viewModelModule,
    repositoryModule,
    appModule,
    itemMapperModule,
    useCaseModule
)
