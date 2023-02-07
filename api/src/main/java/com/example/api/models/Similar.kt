package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Similar(
    @Json(name = "artist")
    val artist: List<ArtistXXXXX>
)