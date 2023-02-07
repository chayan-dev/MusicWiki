package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TopAlbumsResponseX(
    @Json(name = "topalbums")
    val topalbums: Topalbums
)