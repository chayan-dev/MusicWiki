package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Topartists(
    @Json(name = "artist")
    val artist: List<ArtistX>,
    @Json(name = "@attr")
    val attr: AttrXX
)