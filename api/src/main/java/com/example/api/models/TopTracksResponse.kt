package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TopTracksResponse(
    @Json(name = "tracks")
    val tracks: Tracks
)