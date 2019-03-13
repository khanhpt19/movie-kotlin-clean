package com.example.movie_kotlin_clean.model

import android.os.Parcelable
import com.example.domain.model.Movie
import com.example.movie_kotlin_clean.model.base.ItemMapper
import com.example.movie_kotlin_clean.model.base.ModelItem
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieItem(
    val id: String,
    val title: String? = null,
    val overview: String? = null,
    val poster_path: String? = null,
    val backdrop_path: String? = null
) : ModelItem(), Parcelable

class MovieItemMapper() : ItemMapper<Movie, MovieItem> {
    override fun mapToDomain(modelItem: MovieItem) = Movie(
        id = modelItem.id,
        title = modelItem.title,
        overview = modelItem.overview,
        poster_path = modelItem.poster_path,
        backdrop_path = modelItem.backdrop_path
    )

    override fun mapToPresentation(model: Movie) = MovieItem(
        id = model.id,
        title = model.title,
        overview = model.overview,
        poster_path = model.poster_path,
        backdrop_path = model.backdrop_path
    )
}
