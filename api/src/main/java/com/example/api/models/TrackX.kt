package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TrackX(
    @Json(name = "artist")
    val artist: ArtistXXX,
    @Json(name = "@attr")
    val attr: AttrXXXXX,
    @Json(name = "duration")
    val duration: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "streamable")
    val streamable: StreamableX,
    @Json(name = "url")
    val url: String
)