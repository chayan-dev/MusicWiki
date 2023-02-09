package com.example.musicwiki.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.api.models.ArtistX
import com.example.musicwiki.databinding.FragmentArtistsBinding
import com.example.musicwiki.ui.recyclerviewItems.ArtistItem
import com.example.musicwiki.ui.viewmodels.DetailsViewModel
import com.example.musicwiki.utils.Resource
import com.xwray.groupie.GroupieAdapter

class ArtistsFragment(
  val genreName: String,
  val onItemClick: (artistName: String) -> Unit
) : Fragment() {

  private var binding: FragmentArtistsBinding? = null
  val detailsViewModel: DetailsViewModel by activityViewModels()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentArtistsBinding.inflate(inflater, container, false)
    return binding?.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    detailsViewModel.getTopArtists(genreName)

    val adapter = GroupieAdapter()
    binding?.artistRv?.adapter = adapter

    detailsViewModel.topArtists.observe({ lifecycle }) { response ->
      when (response) {
        is Resource.Success -> {
          response.data?.let {
            val artistList = it.topartists.artist.toArtistItem()
            adapter.updateAsync(artistList)
          }
        }
        else -> {}
      }
    }
  }

  private fun List<ArtistX>.toArtistItem(): List<ArtistItem> {
    return this.map {
      ArtistItem(it,
        onClick = { artistName ->
          onItemClick(artistName)
        })
    }
  }
}