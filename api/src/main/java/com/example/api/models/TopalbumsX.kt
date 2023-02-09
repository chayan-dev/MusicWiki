package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TopalbumsX(
    @Json(name = "album")
    val album: List<AlbumXXX>,
    @Json(name = "@attr")
    val attr: AttrXXXXXXXXX
)