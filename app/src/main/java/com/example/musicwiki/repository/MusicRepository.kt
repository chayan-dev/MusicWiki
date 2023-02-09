package com.example.musicwiki.repository

import com.example.api.LastfmClient

class MusicRepository {

  private val api = LastfmClient.api

  suspend fun getTags() = api.getTags()

  suspend fun getTagDetails(tag:String)= api.getTagDetails(tag = tag)

  suspend fun getTopAlbumsByTag(tag: String) =
    api.getTopAlbumsByTag(tag = tag)

  suspend fun getTopArtistsByTag(tag: String) =
    api.getTopArtistsByTag(tag = tag)

  suspend fun getTopTracksByTag(tag: String) =
    api.getTopTracksByTag(tag = tag)

  suspend fun getAlbumDetails(artist: String, album: String) =
    api.getAlbumDetails(artist= artist, album = album )

  suspend fun getArtistDetails(artist: String) =
    api.getArtistDetails(artist= artist)

  suspend fun getTopAlbumsByArtist(artist: String)=
    api.getTopAlbumsByArtist(artist= artist)

  suspend fun getTopTracksByArtist(artist: String)=
    api.getTopTracksByArtist(artist= artist)
}