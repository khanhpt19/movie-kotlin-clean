package com.example.movie_kotlin_clean.ui.screen.detail

import com.example.movie_kotlin_clean.R
import com.example.movie_kotlin_clean.databinding.FragmentDetailBinding
import com.example.movie_kotlin_clean.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment :
    BaseFragment<FragmentDetailBinding, DetailViewModel>() {
    override val viewModel by viewModel<DetailViewModel>()
    override val layoutId: Int = R.layout.fragment_detail

    companion object {
        const val TAG = "DetailFragment"
        fun newInstance() = DetailFragment()
    }
}
