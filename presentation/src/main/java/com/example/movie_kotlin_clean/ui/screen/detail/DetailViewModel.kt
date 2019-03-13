package com.example.movie_kotlin_clean.ui.screen.detail

import androidx.lifecycle.MutableLiveData
import com.example.movie_kotlin_clean.model.MovieItem
import com.example.movie_kotlin_clean.ui.base.BaseViewModel

class DetailViewModel : BaseViewModel(){
    val movie = MutableLiveData<MovieItem>()

}
