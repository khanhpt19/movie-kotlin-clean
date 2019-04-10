package com.example.movie_kotlin_clean.ui.screen.popular

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movie_kotlin_clean.R
import com.example.movie_kotlin_clean.databinding.FragmentLoadmoreRefreshBinding
import com.example.movie_kotlin_clean.model.MovieItem
import com.example.movie_kotlin_clean.ui.base.BaseLoadMoreRefreshFragment
import com.example.movie_kotlin_clean.ui.screen.detail.DetailFragment
import kotlinx.android.synthetic.main.fragment_loadmore_refresh.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PopularFragment :
    BaseLoadMoreRefreshFragment<FragmentLoadmoreRefreshBinding, PopularViewModel, MovieItem>() {
    override val viewModel by viewModel<PopularViewModel>()

    companion object {
        const val TAG = "PopularFragment"
        fun newInstance() = PopularFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val movieAdapter = MovieAdapter { goToDetail(it) }
        recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    DividerItemDecoration.VERTICAL
                )
            )
            adapter = movieAdapter
        }

        viewModel.listItem.observe(viewLifecycleOwner, Observer {
            movieAdapter.submitList(it)
        })
        viewModel.firstLoad()
    }

    private fun goToDetail(movieItem: MovieItem?) {
        addChildFragment(DetailFragment.newInstance(movieItem), R.id.container, DetailFragment.TAG, true)
    }
}
