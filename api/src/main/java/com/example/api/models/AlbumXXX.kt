package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AlbumXXX(
    @Json(name = "artist")
    val artist: ArtistXXXXXXXX,
    @Json(name = "image")
    val image: List<ImageXXXXXXX>,
    @Json(name = "mbid")
    val mbid: String?,
    @Json(name = "name")
    val name: String,
    @Json(name = "playcount")
    val playcount: Int,
    @Json(name = "url")
    val url: String
)