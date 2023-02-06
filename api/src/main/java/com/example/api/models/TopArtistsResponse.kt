package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TopArtistsResponse(
    @Json(name = "@attr")
    val attr: Attr,
    @Json(name = "image")
    val image: List<Image>,
    @Json(name = "mbid")
    val mbid: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "streamable")
    val streamable: String,
    @Json(name = "url")
    val url: String
)