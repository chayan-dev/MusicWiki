package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TracksX(
    @Json(name = "track")
    val track: List<TrackX>
)