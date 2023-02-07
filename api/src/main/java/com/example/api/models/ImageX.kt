package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImageX(
    @Json(name = "size")
    val size: String,
    @Json(name = "#text")
    val text: String
)