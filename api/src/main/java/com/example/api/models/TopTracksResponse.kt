package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TopTracksResponse(
    @Json(name = "artist")
    val artist: Artist,
    @Json(name = "@attr")
    val attr: Attr,
    @Json(name = "duration")
    val duration: String,
    @Json(name = "image")
    val image: List<Image>,
    @Json(name = "mbid")
    val mbid: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "streamable")
    val streamable: Streamable,
    @Json(name = "url")
    val url: String
)