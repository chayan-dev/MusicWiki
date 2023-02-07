package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Tag(
    @Json(name = "count")
    val count: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "reach")
    val reach: Int
)