package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TrackXXX(
    @Json(name = "artist")
    val artist: ArtistXXXXXXXXX,
    @Json(name = "@attr")
    val attr: AttrXXXXXXXXXXX,
    @Json(name = "image")
    val image: List<ImageXXXXXXXX>,
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