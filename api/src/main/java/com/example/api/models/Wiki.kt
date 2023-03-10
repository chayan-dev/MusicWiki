package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Wiki(
    @Json(name = "content")
    val content: String,
    @Json(name = "published")
    val published: String,
    @Json(name = "summary")
    val summary: String
)