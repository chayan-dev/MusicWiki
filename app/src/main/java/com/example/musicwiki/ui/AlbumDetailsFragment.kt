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
import androidx.navigation.fragment.navArgs
import com.example.musicwiki.R
import com.example.musicwiki.databinding.FragmentAlbumDetailsBinding
import com.example.musicwiki.utils.Resource

class AlbumDetailsFragment : Fragment() {

  private var binding: FragmentAlbumDetailsBinding? = null
  val args: AlbumDetailsFragmentArgs by navArgs()
  private val viewModel: DetailsViewModel by activityViewModels()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentAlbumDetailsBinding.inflate(inflater,container,false)
    return binding?.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val albumName = args.albumName
    val artistName = args.artistName

    viewModel.getAlbumDetails(albumName,artistName)
    binding?.albumDescTv?.setOnClickListener {
      findNavController().navigate(
        R.id.action_albumDetailsFragment_to_genreDetailsFragment,
        bundleOf("genreName" to "rock")
      )
    }

    viewModel.albumDetails.observe({lifecycle}){ response->
      when(response){
        is Resource.Success -> {
          response.data?.let { details->
            binding?.let {
              it.titleTv.text = details.album.name
              it.descTv.text = details.album.artist
              it.albumDescTv.text = details.album.wiki.summary
            }
          }
        }
        else -> {}
      }
    }
  }

}