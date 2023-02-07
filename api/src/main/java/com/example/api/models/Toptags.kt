package com.example.api.models


import com.example.api.models.Attr
import com.example.api.models.Tag
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Toptags(
    @Json(name = "@attr")
    val attr: Attr,
    @Json(name = "tag")
    val tag: List<Tag>
)