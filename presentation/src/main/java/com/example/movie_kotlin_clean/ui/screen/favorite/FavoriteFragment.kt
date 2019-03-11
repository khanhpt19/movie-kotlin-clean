package com.example.movie_kotlin_clean.ui.screen.favorite

import com.example.movie_kotlin_clean.R
import com.example.movie_kotlin_clean.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.movie_kotlin_clean.databinding.FragmentFavoriteBinding

class FavoriteFragment :
    BaseFragment<FragmentFavoriteBinding, FavoriteViewModel>() {
    override val viewModel by viewModel<FavoriteViewModel>()
    override val layoutId: Int = R.layout.fragment_favorite

    companion object {
        const val TAG = "FavoriteFragment"
        fun newInstance() = FavoriteFragment()
    }
}
