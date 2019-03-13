package com.example.movie_kotlin_clean.ui.screen.detail

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.movie_kotlin_clean.R
import com.example.movie_kotlin_clean.databinding.FragmentDetailBinding
import com.example.movie_kotlin_clean.model.MovieItem
import com.example.movie_kotlin_clean.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment :
    BaseFragment<FragmentDetailBinding, DetailViewModel>() {
    override val viewModel by viewModel<DetailViewModel>()
    override val layoutId: Int = R.layout.fragment_detail

    companion object {
        const val MOVIE = "MOVIE"
        const val TAG = "DetailFragment"

        fun newInstance(movieItem: MovieItem?) = DetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable(MOVIE, movieItem)
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val movie: MovieItem? = arguments?.getParcelable(MOVIE)
        viewModel.movie.value = movie
        setTitleToolbar(movie?.title.toString())
    }
}
