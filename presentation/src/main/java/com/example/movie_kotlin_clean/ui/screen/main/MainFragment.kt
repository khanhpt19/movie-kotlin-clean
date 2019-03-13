package com.example.movie_kotlin_clean.ui.screen.main

import android.os.Bundle
import com.example.movie_kotlin_clean.R
import com.example.movie_kotlin_clean.databinding.FragmentMainBinding
import com.example.movie_kotlin_clean.ui.base.BaseFragment
import com.example.movie_kotlin_clean.ui.screen.favorite.FavoriteFragment
import com.example.movie_kotlin_clean.ui.screen.popular.PopularFragment
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {
    override val viewModel by viewModel<MainViewModel>()
    override val layoutId: Int = R.layout.fragment_main

    companion object {
        const val TAG = "MainFragment"

        fun newInstance() = MainFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (savedInstanceState == null)
            replaceFragment(PopularFragment.newInstance(), PopularFragment.TAG)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_popular -> {
                    var fragment = findFragment(PopularFragment.TAG)
                    if (fragment == null) {
                        fragment = PopularFragment.newInstance()
                    }
                    replaceFragment(fragment, PopularFragment.TAG)
                    true
                }
                R.id.nav_favorite -> {
                    var fragment = findFragment(FavoriteFragment.TAG)
                    if (fragment == null) {
                        fragment = FavoriteFragment.newInstance()
                    }
                    replaceFragment(fragment, FavoriteFragment.TAG)
                    true
                }
                else -> false
            }
        }
    }
}
