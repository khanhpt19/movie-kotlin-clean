package com.example.movie_kotlin_clean.ui.screen.popular

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.model.Movie
import com.example.movie_kotlin_clean.R
import com.example.movie_kotlin_clean.databinding.ItemMovieBinding
import com.example.movie_kotlin_clean.ui.base.BaseRecyclerAdapter

class MovieAdapter(val itemClickListener: (Movie) -> Unit = {}) : BaseRecyclerAdapter<Movie, ItemMovieBinding>(object :
    DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
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
