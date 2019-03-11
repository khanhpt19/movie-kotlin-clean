package com.example.data.model

import androidx.room.Entity
import com.example.data.model.base.EntityMapper
import com.example.data.model.base.ModelEntity
import com.example.domain.model.Movie
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie", primaryKeys = ["id"])
data class MovieEntity(
    @field:SerializedName("id") val id: String,
    @field:SerializedName("title") val title: String? = null,
    @field:SerializedName("overview") val overview: String? = null
) : ModelEntity()

class MovieEntityMapper : EntityMapper<Movie, MovieEntity> {
    override fun mapToDomain(entity: MovieEntity) = Movie(
        id = entity.id,
        title = entity.title,
        overview = entity.overview
    )

    override fun mapToEntity(model: Movie) = MovieEntity(
        id = model.id,
        title = model.title,
        overview = model.overview
    )
}
