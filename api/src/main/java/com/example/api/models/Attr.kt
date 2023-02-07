package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Attr(
    @Json(name = "num_res")
    val numRes: Int?,
    @Json(name = "offset")
    val offset: Int?,
    @Json(name = "total")
    val total: Int?
)