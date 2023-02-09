package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TopAlbumsByArtistResponse(
    @Json(name = "topalbums")
    val topalbums: TopalbumsX
)