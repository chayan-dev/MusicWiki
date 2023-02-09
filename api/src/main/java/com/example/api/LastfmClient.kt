package com.example.api

import com.example.api.utils.Constants.Companion.BASE_URL
import com.example.api.sevices.LastfmAPI
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object LastfmClient {

  val retrofitBuilder = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())

  val api = retrofitBuilder
    .build()
    .create(LastfmAPI::class.java)
}