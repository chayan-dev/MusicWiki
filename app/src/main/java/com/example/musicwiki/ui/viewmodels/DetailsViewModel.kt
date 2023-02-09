package com.example.musicwiki.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.models.*
import com.example.musicwiki.repository.MusicRepository
import com.example.musicwiki.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class DetailsViewModel(
  val musicRepository: MusicRepository
) : ViewModel() {

  val genreDetails: MutableLiveData<Resource<GenreDetailsResponse>> = MutableLiveData()
  val topAlbums: MutableLiveData<Resource<TopAlbumsResponse>> = MutableLiveData()
  val topArtists: MutableLiveData<Resource<TopArtistsResponse>> = MutableLiveData()
  val topTracks: MutableLiveData<Resource<TopTracksResponse>> = MutableLiveData()
  val albumDetails: MutableLiveData<Resource<AlbumDetailsResponse>> = MutableLiveData()
  val artistDetails: MutableLiveData<Resource<ArtistDetailsResponse>> = MutableLiveData()
  val topTracksByArtist: MutableLiveData<Resource<TopTracksByArtistResponse>> = MutableLiveData()
  val topAlbumsByArtist: MutableLiveData<Resource<TopAlbumsByArtistResponse>> = MutableLiveData()
  val genre: MutableLiveData<Resource<TagsResponse>> = MutableLiveData()

  fun getGenre() = viewModelScope.launch {
    genre.postValue(Resource.Loading())
    val response = musicRepository.getTags()
    genre.postValue(handleTagsResponse(response))
  }

  private fun handleTagsResponse(response: Response<TagsResponse>): Resource<TagsResponse> {
    if (response.isSuccessful) {
      response.body()?.let { tagsResponse ->
        return Resource.Success(tagsResponse)
      }
    }
    return Resource.Error(response.message())
  }

  fun getGenreDetails(tag: String) = viewModelScope.launch {
    genreDetails.postValue(Resource.Loading())
    val response = musicRepository.getTagDetails(tag)
    genreDetails.postValue(handleGenreDetailsResponse(response))
  }

  fun getTopAlbums(tag: String) = viewModelScope.launch {
    topAlbums.postValue(Resource.Loading())
    val response = musicRepository.getTopAlbumsByTag(tag)
    topAlbums.postValue(handleTopAlbumsResponse(response))
  }

  fun getTopArtists(tag: String) = viewModelScope.launch {
    topArtists.postValue(Resource.Loading())
    val response = musicRepository.getTopArtistsByTag(tag)
    topArtists.postValue(handleTopArtistsResponse(response))
  }

  fun getTopTracks(tag: String) = viewModelScope.launch {
    topTracks.postValue(Resource.Loading())
    val response = musicRepository.getTopTracksByTag(tag)
    topTracks.postValue(handleTopTracksResponse(response))
  }

  fun getAlbumDetails(album: String, artist: String) = viewModelScope.launch {
    albumDetails.postValue(Resource.Loading())
    val response = musicRepository.getAlbumDetails(artist, album)
    albumDetails.postValue(handleAlbumDetailsResponse(response))
  }

  fun getArtistDetails(tag: String) = viewModelScope.launch {
    artistDetails.postValue(Resource.Loading())
    val response = musicRepository.getArtistDetails(tag)
    artistDetails.postValue(handleArtistDetailsResponse(response))
  }

  fun getTopTracksByArtist(tag: String) = viewModelScope.launch {
    topTracksByArtist.postValue(Resource.Loading())
    val response = musicRepository.getTopTracksByArtist(tag)
    topTracksByArtist.postValue(handleTopTracksByArtistResponse(response))
  }

  fun getTopAlbumsByArtist(tag: String) = viewModelScope.launch {
    topAlbumsByArtist.postValue(Resource.Loading())
    val response = musicRepository.getTopAlbumsByArtist(tag)
    topAlbumsByArtist.postValue(handleTopAlbumsByArtistResponse(response))
  }

  private fun handleGenreDetailsResponse(response: Response<GenreDetailsResponse>): Resource<GenreDetailsResponse> {
    if (response.isSuccessful) {
      response.body()?.let { tagDetailResponse ->
        return Resource.Success(tagDetailResponse)
      }
    }
    return Resource.Error(response.message())
  }

  private fun handleTopAlbumsResponse(response: Response<TopAlbumsResponse>): Resource<TopAlbumsResponse> {
    if (response.isSuccessful) {
      response.body()?.let { tagDetailResponse ->
        return Resource.Success(tagDetailResponse)
      }
    }
    return Resource.Error(response.message())
  }

  private fun handleTopArtistsResponse(response: Response<TopArtistsResponse>): Resource<TopArtistsResponse> {
    if (response.isSuccessful) {
      response.body()?.let { tagDetailResponse ->
        return Resource.Success(tagDetailResponse)
      }
    }
    return Resource.Error(response.message())
  }

  private fun handleTopTracksResponse(response: Response<TopTracksResponse>): Resource<TopTracksResponse> {
    if (response.isSuccessful) {
      response.body()?.let { tagDetailResponse ->
        return Resource.Success(tagDetailResponse)
      }
    }
    return Resource.Error(response.message())
  }

  private fun handleAlbumDetailsResponse(response: Response<AlbumDetailsResponse>): Resource<AlbumDetailsResponse> {
    if (response.isSuccessful) {
      response.body()?.let { tagDetailResponse ->
        return Resource.Success(tagDetailResponse)
      }
    }
    return Resource.Error(response.message())
  }

  private fun handleArtistDetailsResponse(response: Response<ArtistDetailsResponse>): Resource<ArtistDetailsResponse> {
    if (response.isSuccessful) {
      response.body()?.let { tagDetailResponse ->
        return Resource.Success(tagDetailResponse)
      }
    }
    return Resource.Error(response.message())
  }

  private fun handleTopTracksByArtistResponse(response: Response<TopTracksByArtistResponse>): Resource<TopTracksByArtistResponse> {
    if (response.isSuccessful) {
      response.body()?.let { tagDetailResponse ->
        return Resource.Success(tagDetailResponse)
      }
    }
    return Resource.Error(response.message())
  }

  private fun handleTopAlbumsByArtistResponse(response: Response<TopAlbumsByArtistResponse>): Resource<TopAlbumsByArtistResponse> {
    if (response.isSuccessful) {
      response.body()?.let { tagDetailResponse ->
        return Resource.Success(tagDetailResponse)
      }
    }
    return Resource.Error(response.message())
  }
}