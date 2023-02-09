package com.example.musicwiki.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.api.models.ArtistX
import com.example.musicwiki.R
import com.example.musicwiki.databinding.FragmentArtistsBinding
import com.example.musicwiki.utils.Resource
import com.xwray.groupie.GroupieAdapter

class ArtistsFragment(
  val genreName: String,
  val onItemClick: (artistName : String ) -> Unit
) : Fragment() {

  private var binding: FragmentArtistsBinding? = null
//  val detailsViewModel by viewModels<DetailsViewModel>({requireParentFragment()})
  val detailsViewModel: DetailsViewModel by activityViewModels()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    binding = FragmentArtistsBinding.inflate(inflater,container, false)
    return binding?.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    detailsViewModel.getTopArtists(genreName)

    val adapter = GroupieAdapter()
    binding?.artistRv?.adapter = adapter

    detailsViewModel.topArtists.observe({lifecycle}){ response->
      when(response){
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

  private fun List<ArtistX>.toArtistItem(): List<ArtistItem>{
    return this.map {
      ArtistItem(it,
        onClick = { artistName ->
          onItemClick(artistName)
        })
    }
  }
}