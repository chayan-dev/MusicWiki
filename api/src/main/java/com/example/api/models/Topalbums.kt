package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Topalbums(
    @Json(name = "album")
    val album: List<AlbumXX>,
    @Json(name = "@attr")
    val attr: AttrXXXXXX
)