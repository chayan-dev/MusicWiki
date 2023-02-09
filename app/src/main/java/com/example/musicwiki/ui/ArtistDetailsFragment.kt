package com.example.musicwiki.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.api.models.AlbumXXX
import com.example.api.models.Tag
import com.example.api.models.TrackXXX
import com.example.musicwiki.R
import com.example.musicwiki.databinding.FragmentArtistDetailsBinding
import com.example.musicwiki.extensions.loadImage
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

    val genreAdapter = GroupieAdapter()
    binding?.genreRv?.adapter = genreAdapter

    viewModel.artistDetails.observe({lifecycle}){ response->
      when(response){
        is Resource.Success -> {
          hideProgressBar()
          response.data?.let { details->
            binding?.let {
              it.coverIv.loadImage(details.artist.image[1].text)
              it.titleTv.text = details.artist.name
              it.playcountTv.text = details.artist.stats.playcount
              it.followersTv.text = details.artist.stats.listeners
              it.albumTv.text = details.artist.bio.summary
            }
          }
        }
        is Resource.Loading -> {
          showProgressBar()
        }
        is Resource.Error->{
          hideProgressBar()
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

    viewModel.genre.observe({lifecycle}){ response->
      when(response){
        is Resource.Success -> {
          hideProgressBar()
          response.data?.let {
            val genreList = it.toptags.tag.toTagItem()
            genreAdapter.addAll(genreList)
          }
        }
        is Resource.Loading -> {
          showProgressBar()
        }
        is Resource.Error->{
          hideProgressBar()
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

  private fun List<Tag>.toTagItem(): List<TagItem>{
    return this.map {
      TagItem(it,
        onClick = {genreName ->
          findNavController().navigate(
            R.id.action_artistDetailsFragment_to_genreDetailsFragment,
            bundleOf("genreName" to genreName)
          )
        })
    }
  }

  private fun hideProgressBar(){
    binding?.loader?.root?.visibility =View.INVISIBLE
  }
  private fun showProgressBar(){
    binding?.loader?.root?.visibility=View.VISIBLE
  }

}