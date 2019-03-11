package com.example.movie_kotlin_clean.ui.base

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.movie_kotlin_clean.R

abstract class BaseActivity<ViewBinding : ViewDataBinding, ViewModel : BaseViewModel> : AppCompatActivity() {
    lateinit var viewBinding: ViewBinding
    abstract val viewModel: ViewModel

    abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, layoutId)
        viewBinding.lifecycleOwner = this
        initComponent(viewBinding, savedInstanceState)
    }

    protected open fun initComponent(viewBinding: ViewDataBinding, savedInstanceState: Bundle?) {}

    override fun onBackPressed() {
        super.onBackPressed()
        supportActionBar?.apply {
            title = getString(R.string.app_name)
            setDisplayHomeAsUpEnabled(false)
            setDisplayShowHomeEnabled(false)
        }
    }

    fun findFragmentByTag(TAG: String?): Fragment? {
        return supportFragmentManager.findFragmentByTag(TAG)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun replaceFragment(container: Int, fragment: Fragment, TAG: String) {
        supportFragmentManager.beginTransaction().replace(container, fragment, TAG).commit()
    }
}
