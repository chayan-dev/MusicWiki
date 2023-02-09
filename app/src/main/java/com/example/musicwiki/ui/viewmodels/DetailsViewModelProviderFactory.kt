package com.example.musicwiki.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.musicwiki.repository.MusicRepository

class DetailsViewModelProviderFactory(
  val musicRepository: MusicRepository
) : ViewModelProvider.Factory {

  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    return DetailsViewModel(musicRepository) as T
  }
}