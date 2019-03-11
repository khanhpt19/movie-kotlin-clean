package com.example.movie_kotlin_clean.model.base

import com.example.domain.model.base.Model

interface ItemMapper<M : Model, MI : ModelItem> {
    fun mapToDomain(modelItem: MI): M

    fun mapToPresentation(model: M): MI
}
