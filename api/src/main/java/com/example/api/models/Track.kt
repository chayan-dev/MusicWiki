package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Track(
    @Json(name = "artist")
    val artist: ArtistXX,
    @Json(name = "@attr")
    val attr: AttrXXXX,
    @Json(name = "duration")
    val duration: String?,
    @Json(name = "image")
    val image: List<ImageXX>,
    @Json(name = "mbid")
    val mbid: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "streamable")
    val streamable: Streamable,
    @Json(name = "url")
    val url: String
)