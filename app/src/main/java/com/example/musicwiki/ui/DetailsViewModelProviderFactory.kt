package com.example.musicwiki.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.musicwiki.MusicViewModel
import com.example.musicwiki.repository.MusicRepository

class DetailsViewModelProviderFactory(
  val musicRepository: MusicRepository
): ViewModelProvider.Factory {

  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    return DetailsViewModel(musicRepository) as T
  }
}