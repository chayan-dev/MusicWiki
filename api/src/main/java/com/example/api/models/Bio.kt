package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Bio(
    @Json(name = "content")
    val content: String,
    @Json(name = "links")
    val links: Links,
    @Json(name = "published")
    val published: String,
    @Json(name = "summary")
    val summary: String
)