package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Track(
    @Json(name = "artist")
    val artist: Artist,
    @Json(name = "@attr")
    val attr: Attr,
    @Json(name = "duration")
    val duration: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "streamable")
    val streamable: Streamable,
    @Json(name = "url")
    val url: String
)