package com.example.musicwiki.repository

import com.example.api.LastfmClient

object MusicRepository {

  val api = LastfmClient.api

  suspend fun getTags() = api.getTags()

  suspend fun getTopAlbumsByTag(tag: String) =
    api.getTopAlbumsByTag(tag = tag)

  suspend fun getTopArtistsByTag(tag: String) =
    api.getTopArtistsByTag(tag = tag)

  suspend fun getTopTracksByTag(tag: String) =
    api.getTopArtistsByTag(tag = tag)

  suspend fun getAlbumDetails(artist: String, album: String) =
    api.getAlbumDetails(artist= artist, album = album )

  suspend fun getArtistDetails(artist: String, album: String) =
    api.getArtistDetails(artist= artist)

  suspend fun getTopAlbumsByArtist(artist: String)=
    api.getTopAlbumsByArtist(artist= artist)

  suspend fun getTopTracksByArtist(artist: String)=
    api.getTopTracksByArtist(artist= artist)
}