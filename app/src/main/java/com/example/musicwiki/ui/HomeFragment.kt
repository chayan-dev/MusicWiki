package com.example.musicwiki.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.api.models.Tag
import com.example.musicwiki.MusicViewModel
import com.example.musicwiki.R
import com.example.musicwiki.databinding.FragmentHomeBinding
import com.example.musicwiki.repository.MusicRepository
import com.example.musicwiki.utils.Resource
import com.xwray.groupie.GroupieAdapter

class HomeFragment : Fragment() {

  private var binding: FragmentHomeBinding? = null
  lateinit var musicViewModel: MusicViewModel

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
//    musicViewModel = ViewModelProvider(this).get(MusicViewModel::class.java)
    val musicRepository = MusicRepository()
    val viewModelProviderFactory = MusicViewModelProviderFactory(musicRepository)
    musicViewModel = ViewModelProvider(this, viewModelProviderFactory).get(MusicViewModel::class.java)
    binding = FragmentHomeBinding.inflate(inflater,container,false)

    return binding?.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
//    musicViewModel = (activity as MusicViewModel)

    musicViewModel.getGenre()

    val adapter = GroupieAdapter()
    binding?.tagsRv?.adapter = adapter

    musicViewModel.genre.observe({lifecycle}){ response->
      when(response){
        is Resource.Success -> {
          response.data?.let {
            val genreList = it.toptags.tag.toGenreItem()
            adapter.addAll(genreList)
          }
        }
        else -> {}
      }
    }
  }

  private fun List<Tag>.toGenreItem(): List<GenreItem>{
    return this.map {
      GenreItem(it,
      onClick = {genreName ->
        findNavController().navigate(
          R.id.action_homeFragment_to_genreDetailsFragment,
          bundleOf("genreName" to genreName)
        )
      })
    }
  }

}