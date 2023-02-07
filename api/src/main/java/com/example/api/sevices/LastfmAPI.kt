package com.example.api.sevices

import com.example.api.models.*
import com.example.api.sevices.Constants.Companion.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface LastfmAPI {

  @GET("2.0/")
  fun getTags(
    @Query("method")
    method: String = "tag.getTopTags",
    @Query("api_key")
    key: String = API_KEY,
    @Query("format")
    format: String = "json"
  ): Call<TagsResponse>

  @GET("2.0/")
  fun getTopAlbumsByTag(
    @Query("method")
    method: String = "tag.gettopalbums",
    @Query("tag")
    tag: String,
    @Query("api_key")
    key: String = API_KEY,
    @Query("format")
    format: String = "json"
  ): Call<TopAlbumsResponse>

  @GET("2.0/")
  fun getTopArtistsByTag(
    @Query("method")
    method: String = "tag.gettopartists",
    @Query("tag")
    tag: String,
    @Query("api_key")
    key: String = API_KEY,
    @Query("format")
    format: String = "json"
  ): Call<TopArtistsResponse>

  @GET("2.0/")
  fun getTopTracksByTag(
    @Query("method")
    method: String = "tag.gettoptracks",
    @Query("tag")
    tag: String,
    @Query("api_key")
    key: String = API_KEY,
    @Query("format")
    format: String = "json"
  ): Call<TopTracksResponse>

  @GET("2.0/")
  fun getAlbumDetails(
    @Query("method")
    method: String = "album.getinfo",
    @Query("api_key")
    key: String = API_KEY,
    @Query("artist")
    artist: String,
    @Query("album")
    album: String,
    @Query("format")
    format: String = "json"
  ): Call<AlbumDetailsResponse>

  @GET("2.0/")
  fun getArtistDetails(
    @Query("method")
    method: String = "tag.gettoptracks",
    @Query("artist")
    artist: String,
    @Query("api_key")
    key: String = API_KEY,
    @Query("format")
    format: String = "json"
  ): Call<ArtistDetailsResponse>

  @GET("2.0/")
  fun getTopAlbumsByArtist(
    @Query("method")
    method: String = "artist.gettopalbums",
    @Query("artist")
    artist: String,
    @Query("api_key")
    key: String = API_KEY,
    @Query("format")
    format: String = "json"
  ): Call<TopAlbumsResponse>

  @GET("2.0/")
  fun getTopTracksByArtist(
    @Query("method")
    method: String = "artist.gettoptracks",
    @Query("artist")
    artist: String,
    @Query("api_key")
    key: String = API_KEY,
    @Query("format")
    format: String = "json"
  ): Call<TopTracksResponse>
}