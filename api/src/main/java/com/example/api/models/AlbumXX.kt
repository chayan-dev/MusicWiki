package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AlbumXX(
    @Json(name = "artist")
    val artist: ArtistXXXXXX,
    @Json(name = "image")
    val image: List<ImageXXXXX>,
    @Json(name = "mbid")
    val mbid: String?,
    @Json(name = "name")
    val name: String,
    @Json(name = "playcount")
    val playcount: Int,
    @Json(name = "url")
    val url: String
)