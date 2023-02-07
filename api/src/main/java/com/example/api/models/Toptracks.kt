package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Toptracks(
    @Json(name = "@attr")
    val attr: AttrXXXXXXX,
    @Json(name = "track")
    val track: List<TrackXX>
)