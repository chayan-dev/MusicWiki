package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArtistXXXXXXX(
    @Json(name = "mbid")
    val mbid: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String
)