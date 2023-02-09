package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArtistXXXX(
    @Json(name = "bio")
    val bio: Bio,
    @Json(name = "image")
    val image: List<ImageXXXX>,
    @Json(name = "mbid")
    val mbid: String?,
    @Json(name = "name")
    val name: String,
    @Json(name = "ontour")
    val ontour: String,
    @Json(name = "similar")
    val similar: Similar,
    @Json(name = "stats")
    val stats: Stats,
    @Json(name = "streamable")
    val streamable: String,
    @Json(name = "tags")
    val tags: TagsX,
    @Json(name = "url")
    val url: String
)