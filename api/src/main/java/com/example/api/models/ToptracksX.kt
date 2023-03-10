package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ToptracksX(
    @Json(name = "@attr")
    val attr: AttrXXXXXXXXXX,
    @Json(name = "track")
    val track: List<TrackXXX>
)