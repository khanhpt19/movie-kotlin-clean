package com.example.movie_kotlin_clean.ui.screen

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.example.movie_kotlin_clean.R
import com.example.movie_kotlin_clean.ui.base.BaseActivity
import com.example.movie_kotlin_clean.ui.screen.main.MainFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.movie_kotlin_clean.databinding.ActivityMainBinding

class MainActivity :
    BaseActivity<ActivityMainBinding, MainActivityViewModel>() {
    override val viewModel by viewModel<MainActivityViewModel>()
    override val layoutId: Int = R.layout.activity_main

    override fun initComponent(viewBinding: ViewDataBinding, savedInstanceState: Bundle?) {
        super.initComponent(viewBinding, savedInstanceState)
        replaceFragment(R.id.container, MainFragment.newInstance(), MainFragment.TAG)
    }
}
