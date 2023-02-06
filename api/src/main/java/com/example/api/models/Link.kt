package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Link(
    @Json(name = "href")
    val href: String,
    @Json(name = "rel")
    val rel: String,
    @Json(name = "#text")
    val text: String
)