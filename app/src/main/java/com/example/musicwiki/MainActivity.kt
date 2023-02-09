package com.example.musicwiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.musicwiki.repository.MusicRepository
import com.example.musicwiki.ui.DetailsViewModel
import com.example.musicwiki.ui.DetailsViewModelProviderFactory
import com.example.musicwiki.ui.MusicViewModelProviderFactory

class MainActivity : AppCompatActivity() {

//   lateinit var viewModel: MusicViewModel
  lateinit var detailsViewModel:DetailsViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

//    val musicRepository = MusicRepository()
//    val viewModelProviderFactory = MusicViewModelProviderFactory(musicRepository)
//    viewModel = ViewModelProvider(this, viewModelProviderFactory).get(MusicViewModel::class.java)

    val musicRepository = MusicRepository()
    val viewModelProviderFactory = DetailsViewModelProviderFactory(musicRepository)
    detailsViewModel = ViewModelProvider(this, viewModelProviderFactory).get(DetailsViewModel::class.java)

    val navHostFragment = supportFragmentManager.findFragmentById(R.id.NavHostFragment) as NavHostFragment
  }
}