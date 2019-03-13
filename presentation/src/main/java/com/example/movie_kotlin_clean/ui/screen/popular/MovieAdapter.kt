package com.example.movie_kotlin_clean.ui.screen.popular

import androidx.recyclerview.widget.DiffUtil
import com.example.movie_kotlin_clean.R
import com.example.movie_kotlin_clean.databinding.ItemMovieBinding
import com.example.movie_kotlin_clean.model.MovieItem
import com.example.movie_kotlin_clean.ui.base.BaseRecyclerAdapter

class MovieAdapter(val itemClickListener: (MovieItem) -> Unit = {}) :
    BaseRecyclerAdapter<MovieItem, ItemMovieBinding>(object :
        DiffUtil.ItemCallback<MovieItem>() {
        override fun areItemsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem.id == newItem.id && oldItem.title == newItem.title
        }

    }) {
    override fun getLayout(viewType: Int): Int {
        return R.layout.item_movie
    }

    override fun itemBinding(binding: ItemMovieBinding) {
        binding.apply {
            root.setOnClickListener {
                item?.apply {
                    itemClickListener(this)
                }
            }
        }
    }

}
