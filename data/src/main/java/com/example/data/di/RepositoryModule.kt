package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.Constants
import com.example.data.MovieRepositoryImpl
import com.example.data.local.db.AppDatabase
import com.example.data.local.pref.AppPrefs
import com.example.data.local.pref.PrefHelper
import com.example.domain.repository.MovieRepository
import com.google.gson.Gson
import org.koin.dsl.module.module
import org.koin.experimental.builder.create

val repositoryModule = module {
    single { createAppDatabase(get(), get()) }
    single { createDatabaseName() }
    single { createMovieDao(get()) }
    single<PrefHelper> { create<AppPrefs>() }
    single { Gson() }
    single<MovieRepository> { create<MovieRepositoryImpl>() }
}

fun createDatabaseName() = Constants.DATABASE_NAME

fun createAppDatabase (dbName: String, context: Context) = Room.databaseBuilder(context, AppDatabase::class.java, dbName).build()

fun createMovieDao(appDatabase: AppDatabase)= appDatabase.movieDao()
