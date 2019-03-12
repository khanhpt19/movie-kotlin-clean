package com.example.movie_kotlin_clean.ui.screen.popular

import android.os.Bundle
import com.example.movie_kotlin_clean.R
import com.example.movie_kotlin_clean.databinding.FragmentPopularBinding
import com.example.movie_kotlin_clean.ui.base.BaseFragment
import com.example.movie_kotlin_clean.ui.screen.detail.DetailFragment
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_popular.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PopularFragment :
    BaseFragment<FragmentPopularBinding, PopularViewModel>() {
    override val viewModel by viewModel<PopularViewModel>()
    override val layoutId: Int = R.layout.fragment_popular

    companion object {
        const val TAG = "PopularFragment"
        fun newInstance() = PopularFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val adapter: MovieAdapter = MovieAdapter(itemClickListener = goToDetail())
        recycler_view_popular.adapter = adapter
//        text_popular.setOnClickListener {
//            addFragment(
//                DetailFragment.newInstance(), DetailFragment.TAG, true
//            )
//        }
    }

    fun goToDetail(){

    }
}
