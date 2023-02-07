package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AttrXX(
    @Json(name = "page")
    val page: String,
    @Json(name = "perPage")
    val perPage: String,
    @Json(name = "tag")
    val tag: String,
    @Json(name = "total")
    val total: String,
    @Json(name = "totalPages")
    val totalPages: String
)