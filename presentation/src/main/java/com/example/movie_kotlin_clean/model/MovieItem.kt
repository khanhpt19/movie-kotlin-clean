package com.example.movie_kotlin_clean.model

import com.example.domain.model.Movie
import com.example.movie_kotlin_clean.model.base.ItemMapper
import com.example.movie_kotlin_clean.model.base.ModelItem

data class MovieItem(
    val id: String,
    val title: String? = null,
    val overview: String? = null
) : ModelItem()

class MovieItemMapper() : ItemMapper<Movie, MovieItem> {
    override fun mapToDomain(modelItem: MovieItem) = Movie(
        id = modelItem.id,
        title = modelItem.title,
        overview = modelItem.overview
    )

    override fun mapToPresentation(model: Movie) = MovieItem(
        id = model.id,
        title = model.title,
        overview = model.overview
    )
}
