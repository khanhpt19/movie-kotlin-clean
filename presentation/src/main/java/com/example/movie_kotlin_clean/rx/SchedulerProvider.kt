package com.example.movie_kotlin_clean.rx

import io.reactivex.Scheduler

interface SchedulerProvider {
    fun ui(): Scheduler

    fun io(): Scheduler
}
