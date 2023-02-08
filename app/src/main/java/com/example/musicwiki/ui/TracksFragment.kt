package com.example.musicwiki.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.api.models.Track
import com.example.musicwiki.R
import com.example.musicwiki.databinding.FragmentTracksBinding
import com.example.musicwiki.utils.Resource
import com.xwray.groupie.GroupieAdapter

class TracksFragment(val genreName: String) : Fragment() {

  private var binding: FragmentTracksBinding? = null
  val detailsViewModel by viewModels<DetailsViewModel>({requireParentFragment()})

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    binding = FragmentTracksBinding.inflate(inflater,container,false)
    return binding?.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    detailsViewModel.getTopTracks(genreName)

    val adapter = GroupieAdapter()
    binding?.tracksRv?.adapter = adapter

    detailsViewModel.topTracks.observe({lifecycle}){ response->
      when(response){
        is Resource.Success -> {
          response.data?.let {
            val trackList = it.tracks.track.toTrackItem()
            adapter.addAll(trackList)
          }
        }
        else -> {}
      }
    }
  }

  private fun List<Track>.toTrackItem(): List<TracksItem>{
    return this.map {
      TracksItem(it,
        onClick = { albumName ->
          findNavController().navigate(
            R.id.action_homeFragment_to_genreDetailsFragment,
            bundleOf("genreName" to albumName)
          )
        })
    }
  }

}