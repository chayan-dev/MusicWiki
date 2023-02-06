package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Stats(
    @Json(name = "listeners")
    val listeners: String,
    @Json(name = "playcount")
    val playcount: String
)