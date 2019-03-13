package com.example.movie_kotlin_clean.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import com.example.movie_kotlin_clean.BR
import com.example.movie_kotlin_clean.R
import com.example.movie_kotlin_clean.utils.DialogUtils

abstract class BaseFragment<ViewBinding : ViewDataBinding, ViewModel : BaseViewModel> : Fragment() {
    lateinit var viewBinding: ViewBinding

    abstract val viewModel: ViewModel

    @get:LayoutRes
    abstract val layoutId: Int

    var loadingDialog: AlertDialog? = null
    var messageDialog: AlertDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.apply {
            setVariable(BR.viewModel, viewModel)
            root.isClickable = true
            setLifecycleOwner(viewLifecycleOwner)
            executePendingBindings()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadingDialog = DialogUtils.createLoadingDialog(context, false)
        viewModel.apply {
            isLoading.observe(viewLifecycleOwner, Observer {
                handleShowLoading(it == true)
            })
            errorMessage.observe(viewLifecycleOwner, Observer {
                hideLoading()
                if (it != null && it.isNotBlank()) {
                    handleShowErrorMessage(it)
                }
            })
        }
    }

    open fun handleShowLoading(isLoading: Boolean) {
        if (isLoading) showLoading() else hideLoading()
    }

    fun handleShowErrorMessage(message: String) {
        messageDialog = DialogUtils.showMessage(
            context, message = message, textPositive = getString(R.string.ok)
        )
    }

    override fun onPause() {
        messageDialog?.dismiss()
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.isLoading.removeObservers(this)
        viewModel.errorMessage.removeObservers(this)
        viewModel.onActivityDestroyed()
    }

    fun showLoading() {
        hideLoading()
        loadingDialog?.show()
    }

    fun hideLoading() {
        if (loadingDialog != null && loadingDialog!!.isShowing) {
            loadingDialog?.cancel()
        }
    }

    /**
     * fragment transaction
     */

    fun findFragment(TAG: String): Fragment? {
        return activity?.supportFragmentManager?.findFragmentByTag(TAG)
    }

    fun findChildFragment(parentFragment: Fragment = this, TAG: String): Fragment? {
        return parentFragment.childFragmentManager.findFragmentByTag(TAG)
    }

    fun addFragment(
        fragment: Fragment, TAG: String?, addToBackStack: Boolean = false,
        transit: Int = -1
    ) {
        activity?.supportFragmentManager?.beginTransaction()
            ?.add(R.id.container, fragment, TAG)?.apply {
                commitTransaction(this, addToBackStack, transit)
            }
    }

    fun replaceFragment(
        fragment: Fragment, TAG: String?, addToBackStack: Boolean = false,
        transit: Int = -1
    ) {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.frame_layout, fragment, TAG)?.apply {
                commitTransaction(this, addToBackStack, transit)
            }
    }

    fun replaceChildFragment(
        parentFragment: Fragment = this, containerViewId: Int,
        fragment: Fragment, TAG: String?, addToBackStack: Boolean = false, transit: Int = -1
    ) {
        val transaction = parentFragment.childFragmentManager.beginTransaction().replace(
            containerViewId, fragment, TAG
        )
        commitTransaction(transaction, addToBackStack, transit)
    }

    fun addChildFragment(
        fragment: Fragment, container: Int, TAG: String?, addToBackStack: Boolean = false
    ) {
        activity?.supportFragmentManager?.beginTransaction()?.add(
            container, fragment, TAG
        )?.apply { commitTransaction(this, addToBackStack) }
    }

    fun addChildFragment(
        parentFragment: Fragment = this, containerViewId: Int,
        targetFragment: Fragment, TAG: String?, addToBackStack: Boolean = false,
        transit: Int = -1
    ) {
        val transaction = parentFragment.childFragmentManager.beginTransaction().add(
            containerViewId, targetFragment, TAG
        )
        commitTransaction(transaction, addToBackStack, transit)
    }

    fun showDialogFragment(
        dialogFragment: DialogFragment, TAG: String?,
        addToBackStack: Boolean = false, transit: Int = -1
    ) {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        if (addToBackStack) transaction?.addToBackStack(TAG)
//        if (transit != -1) transaction?.setTransition(transit)
        dialogFragment.show(transaction, TAG)
    }

    private fun commitTransaction(
        transaction: FragmentTransaction, addToBackStack: Boolean = false,
        transit: Int = -1
    ) {
        if (addToBackStack) transaction.addToBackStack(null)
//        if (transit != -1) transaction.setTransition(transit)
        transaction.commit()
    }

    fun popChildFragment(parentFragment: Fragment = this) {
        parentFragment.childFragmentManager.popBackStack()
    }

    open fun onBack(): Boolean {
        return false
    }

    fun setTitleToolbar(titleToolbar: String) {
        if (activity is AppCompatActivity) {
            (activity as AppCompatActivity).apply {
                supportActionBar?.apply {
                    title = titleToolbar
                    setDisplayHomeAsUpEnabled(true)
                    setDisplayShowHomeEnabled(true)
                }
            }
        }
    }
}
