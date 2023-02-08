package com.example.musicwiki

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.models.TagsResponse
import com.example.musicwiki.repository.MusicRepository
import com.example.musicwiki.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

public class MusicViewModel(
  val musicRepository: MusicRepository
): ViewModel() {

  val genre:MutableLiveData<Resource<TagsResponse>> = MutableLiveData()
  var genreResponse: TagsResponse? = null

  fun getGenre() = viewModelScope.launch {
    genre.postValue(Resource.Loading())
    val response = musicRepository.getTags()
    genre.postValue(handleTagsResponse(response))
  }

  private fun handleTagsResponse(response: Response<TagsResponse>) : Resource<TagsResponse>{
    if(response.isSuccessful){
      response.body()?.let {  tagsResponse ->
        return Resource.Success(tagsResponse)
      }
    }
    return Resource.Error(response.message())
  }
}