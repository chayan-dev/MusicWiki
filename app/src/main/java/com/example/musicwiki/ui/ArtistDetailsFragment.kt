package com.example.musicwiki.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.api.models.Album
import com.example.api.models.AlbumXXX
import com.example.api.models.TrackXXX
import com.example.musicwiki.databinding.FragmentArtistDetailsBinding
import com.example.musicwiki.utils.Resource
import com.xwray.groupie.GroupieAdapter

class ArtistDetailsFragment : Fragment() {



  private var binding: FragmentArtistDetailsBinding? =  null
  val args: ArtistDetailsFragmentArgs by navArgs()
  private val viewModel: DetailsViewModel by activityViewModels()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    binding = FragmentArtistDetailsBinding.inflate(inflater,container, false)
    return binding?.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val artistName = args.artistName

    viewModel.getArtistDetails(artistName)
    viewModel.getTopTracksByArtist(artistName)
    viewModel.getTopAlbumsByArtist(artistName)

    val albumsAdapter = GroupieAdapter()
    binding?.topAlbumsRv?.adapter = albumsAdapter

    val tracksAdapter = GroupieAdapter()
    binding?.topTracksRv?.adapter = tracksAdapter

    viewModel.artistDetails.observe({lifecycle}){ response->
      when(response){
        is Resource.Success -> {
          response.data?.let { details->
            binding?.let {
              it.titleTv.text = details.artist.name
              it.playcountTv.text = details.artist.stats.playcount
              it.followersTv.text = details.artist.stats.listeners
              it.albumTv.text = details.artist.bio.summary
            }
          }
        }
        else -> {}
      }
    }

    viewModel.topTracksByArtist.observe({lifecycle}){ response->
      when(response){
        is Resource.Success -> {
          response.data?.let {
            val tracksList = it.toptracks.track.toTracksItem()
            tracksAdapter.updateAsync(tracksList)
          }
        }
        else -> {}
      }
    }

    viewModel.topAlbumsByArtist.observe({lifecycle}){ response->
      when(response){
        is Resource.Success -> {
          response.data?.let {
            val albumsList = it.topalbums.album.toAlbumItem()
            albumsAdapter.updateAsync(albumsList)
          }
        }
        else -> {}
      }
    }
  }

  private fun List<TrackXXX>.toTracksItem(): List<TopTracksItem>{
    return this.map {
      TopTracksItem(it)
    }
  }

  private fun List<AlbumXXX>.toAlbumItem(): List<TopAlbumsItem>{
    return this.map {
      TopAlbumsItem(it)
    }
  }

}