package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TopTracksResponseX(
    @Json(name = "toptracks")
    val toptracks: Toptracks
)