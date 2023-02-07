package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Albums(
    @Json(name = "album")
    val album: List<Album>,
    @Json(name = "@attr")
    val attr: Attr
)