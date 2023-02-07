package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArtistDetailsResponse(
    @Json(name = "artist")
    val artist: ArtistXXXX
)