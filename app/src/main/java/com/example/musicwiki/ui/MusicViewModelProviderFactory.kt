package com.example.musicwiki.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.musicwiki.MusicViewModel
import com.example.musicwiki.repository.MusicRepository

class MusicViewModelProviderFactory(
  val musicRepository: MusicRepository
): ViewModelProvider.Factory {

  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    return MusicViewModel(musicRepository) as T
  }
}