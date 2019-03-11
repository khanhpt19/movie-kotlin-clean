package com.example.movie_kotlin_clean.ui.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open class BaseViewHolder<ViewBinding : ViewDataBinding> constructor(val binding: ViewBinding) :
    RecyclerView.ViewHolder(binding.root)
