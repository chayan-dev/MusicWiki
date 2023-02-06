package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TagDetailsResponse(
    @Json(name = "name")
    val name: String,
    @Json(name = "reach")
    val reach: Int,
    @Json(name = "total")
    val total: Int,
    @Json(name = "wiki")
    val wiki: Wiki
)