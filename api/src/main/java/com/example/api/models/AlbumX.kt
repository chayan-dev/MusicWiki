package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AlbumX(
    @Json(name = "artist")
    val artist: String,
    @Json(name = "image")
    val image: List<ImageXXX>,
    @Json(name = "listeners")
    val listeners: String,
    @Json(name = "mbid")
    val mbid: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "playcount")
    val playcount: String,
    @Json(name = "tags")
    val tags: Tags,
    @Json(name = "tracks")
    val tracks: TracksX,
    @Json(name = "url")
    val url: String,
    @Json(name = "wiki")
    val wiki: Wiki
)