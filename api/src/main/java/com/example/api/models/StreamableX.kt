package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StreamableX(
    @Json(name = "fulltrack")
    val fulltrack: String,
    @Json(name = "#text")
    val text: String
)