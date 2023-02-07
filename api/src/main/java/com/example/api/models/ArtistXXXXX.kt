package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArtistXXXXX(
    @Json(name = "image")
    val image: List<ImageXXXX>,
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String
)