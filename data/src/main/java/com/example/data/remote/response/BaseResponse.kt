package com.example.data.remote.response

import com.example.data.model.MovieEntity
import com.google.gson.annotations.SerializedName

class BaseResponse(
    @SerializedName("page") val page: Int? = null,
    @SerializedName("total_results") val total_results: Int? = null,
    @SerializedName("total_pages") val total_pages: Int? = null,
    @SerializedName("results") val results: List<MovieEntity>? = null
)
