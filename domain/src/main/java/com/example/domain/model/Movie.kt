package com.example.domain.model

import com.example.domain.model.base.Model

data class Movie(
    val id: String,
    val title: String? = null,
    val overview: String? = null
) : Model()
