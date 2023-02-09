package com.example.api.sevices

import com.example.api.models.*
import com.example.api.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LastfmAPI {

  @GET("2.0/")
  suspend fun getTags(
    @Query("method")
    method: String = "tag.getTopTags",
    @Query("api_key")
    key: String = API_KEY,
    @Query("format")
    format: String = "json"
  ): Response<TagsResponse>

  @GET("2.0/")
  suspend fun getTagDetails(
    @Query("method")
    method: String = "tag.getinfo",
    @Query("tag")
    tag: String,
    @Query("api_key")
    key: String = API_KEY,
    @Query("format")
    format: String = "json"
  ): Response<GenreDetailsResponse>

  @GET("2.0/")
  suspend fun getTopAlbumsByTag(
    @Query("method")
    method: String = "tag.gettopalbums",
    @Query("tag")
    tag: String,
    @Query("api_key")
    key: String = API_KEY,
    @Query("format")
    format: String = "json"
  ): Response<TopAlbumsResponse>

  @GET("2.0/")
  suspend fun getTopArtistsByTag(
    @Query("method")
    method: String = "tag.gettopartists",
    @Query("tag")
    tag: String,
    @Query("api_key")
    key: String = API_KEY,
    @Query("format")
    format: String = "json"
  ): Response<TopArtistsResponse>

  @GET("2.0/")
  suspend fun getTopTracksByTag(
    @Query("method")
    method: String = "tag.gettoptracks",
    @Query("tag")
    tag: String,
    @Query("api_key")
    key: String = API_KEY,
    @Query("format")
    format: String = "json"
  ): Response<TopTracksResponse>

  @GET("2.0/")
  suspend fun getAlbumDetails(
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
  ): Response<AlbumDetailsResponse>

  @GET("2.0/")
  suspend fun getArtistDetails(
    @Query("method")
    method: String = "artist.getinfo",
    @Query("artist")
    artist: String,
    @Query("api_key")
    key: String = API_KEY,
    @Query("format")
    format: String = "json"
  ): Response<ArtistDetailsResponse>

  @GET("2.0/")
  suspend fun getTopAlbumsByArtist(
    @Query("method")
    method: String = "artist.gettopalbums",
    @Query("artist")
    artist: String,
    @Query("api_key")
    key: String = API_KEY,
    @Query("format")
    format: String = "json"
  ): Response<TopAlbumsByArtistResponse>

  @GET("2.0/")
  suspend fun getTopTracksByArtist(
    @Query("method")
    method: String = "artist.gettoptracks",
    @Query("artist")
    artist: String,
    @Query("api_key")
    key: String = API_KEY,
    @Query("format")
    format: String = "json"
  ): Response<TopTracksByArtistResponse>
}