package com.example.musicwiki.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.models.GenreDetailsResponse
import com.example.api.models.TopAlbumsResponse
import com.example.api.models.TopArtistsResponse
import com.example.api.models.TopTracksResponse
import com.example.musicwiki.repository.MusicRepository
import com.example.musicwiki.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class DetailsViewModel(
  val musicRepository: MusicRepository
): ViewModel() {

  val genreDetails: MutableLiveData<Resource<GenreDetailsResponse>> = MutableLiveData()
  val topAlbums: MutableLiveData<Resource<TopAlbumsResponse>> = MutableLiveData()
  val topArtists: MutableLiveData<Resource<TopArtistsResponse>> = MutableLiveData()
  val topTracks: MutableLiveData<Resource<TopTracksResponse>> = MutableLiveData()

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

  private fun handleGenreDetailsResponse(response: Response<GenreDetailsResponse>) : Resource<GenreDetailsResponse>{
    if(response.isSuccessful){
      response.body()?.let {  tagDetailResponse ->
        return Resource.Success(tagDetailResponse)
      }
    }
    return Resource.Error(response.message())
  }

  private fun handleTopAlbumsResponse(response: Response<TopAlbumsResponse>) : Resource<TopAlbumsResponse>{
    if(response.isSuccessful){
      response.body()?.let {  tagDetailResponse ->
        return Resource.Success(tagDetailResponse)
      }
    }
    return Resource.Error(response.message())
  }

  private fun handleTopArtistsResponse(response: Response<TopArtistsResponse>) : Resource<TopArtistsResponse>{
    if(response.isSuccessful){
      response.body()?.let {  tagDetailResponse ->
        return Resource.Success(tagDetailResponse)
      }
    }
    return Resource.Error(response.message())
  }

  private fun handleTopTracksResponse(response: Response<TopTracksResponse>) : Resource<TopTracksResponse>{
    if(response.isSuccessful){
      response.body()?.let {  tagDetailResponse ->
        return Resource.Success(tagDetailResponse)
      }
    }
    return Resource.Error(response.message())
  }
}