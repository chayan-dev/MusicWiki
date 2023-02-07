package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TagsX(
    @Json(name = "tag")
    val tag: List<TagXX>
)