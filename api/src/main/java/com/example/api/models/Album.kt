package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Album(
    @Json(name = "artist")
    val artist: Artist,
    @Json(name = "@attr")
    val attr: Attr,
    @Json(name = "image")
    val image: List<Image>,
    @Json(name = "mbid")
    val mbid: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String
)