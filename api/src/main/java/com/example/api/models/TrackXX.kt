package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TrackXX(
    @Json(name = "artist")
    val artist: ArtistXXXXXXX,
    @Json(name = "@attr")
    val attr: AttrXXXXXXXX,
    @Json(name = "image")
    val image: List<ImageXXXXXX>,
    @Json(name = "listeners")
    val listeners: String,
    @Json(name = "mbid")
    val mbid: String?,
    @Json(name = "name")
    val name: String,
    @Json(name = "playcount")
    val playcount: String,
    @Json(name = "streamable")
    val streamable: String,
    @Json(name = "url")
    val url: String
)