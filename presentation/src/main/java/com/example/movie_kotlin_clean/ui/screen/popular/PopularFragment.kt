package com.example.movie_kotlin_clean.ui.screen.popular

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.movie_kotlin_clean.R
import com.example.movie_kotlin_clean.databinding.FragmentPopularBinding
import com.example.movie_kotlin_clean.model.MovieItem
import com.example.movie_kotlin_clean.ui.base.BaseLoadMoreRefreshFragment
import com.example.movie_kotlin_clean.ui.screen.detail.DetailFragment
import kotlinx.android.synthetic.main.fragment_popular.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PopularFragment :
    BaseLoadMoreRefreshFragment<FragmentPopularBinding, PopularViewModel, MovieItem>() {
    override val viewModel by viewModel<PopularViewModel>()
    override val layoutId: Int = R.layout.fragment_popular

    companion object {
        const val TAG = "PopularFragment"
        fun newInstance() = PopularFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val adapter = MovieAdapter { goToDetail(it) }
        recycler_view_popular.adapter = adapter

        viewModel.listItem.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
        viewModel.loadData(1)
    }

    private fun goToDetail(movieItem: MovieItem?) {
        addChildFragment(DetailFragment.newInstance(movieItem), R.id.container, DetailFragment.TAG, true)
    }
}
