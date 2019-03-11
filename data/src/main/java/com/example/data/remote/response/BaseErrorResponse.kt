package com.example.data.remote.response

import com.example.data.remote.Error
import com.google.gson.annotations.SerializedName

class BaseErrorResponse(
    @SerializedName("code") var code: Int? = null,
    @SerializedName("message") val message: String? = null,
    @SerializedName("errors") val errors: List<Error>? = null
)