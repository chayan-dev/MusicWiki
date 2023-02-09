package com.example.musicwiki.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.api.models.Tag
import com.example.musicwiki.R
import com.example.musicwiki.databinding.FragmentAlbumDetailsBinding
import com.example.musicwiki.extensions.loadImage
import com.example.musicwiki.ui.viewmodels.DetailsViewModel
import com.example.musicwiki.ui.recyclerviewItems.TagItem
import com.example.musicwiki.utils.Resource
import com.xwray.groupie.GroupieAdapter

class AlbumDetailsFragment : Fragment() {

  private var binding: FragmentAlbumDetailsBinding? = null
  val args: AlbumDetailsFragmentArgs by navArgs()
  private val viewModel: DetailsViewModel by activityViewModels()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentAlbumDetailsBinding.inflate(inflater, container, false)
    return binding?.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val albumName = args.albumName
    val artistName = args.artistName
    viewModel.getAlbumDetails(albumName, artistName)

    val adapter = GroupieAdapter()
    binding?.genreRv?.adapter = adapter

    viewModel.albumDetails.observe({ lifecycle }) { response ->
      when (response) {
        is Resource.Success -> {
          hideProgressBar()
          response.data?.let { details ->
            binding?.let {
              it.coverIv.loadImage(details.album.image[1].text)
              it.titleTv.text = details.album.name
              it.descTv.text = details.album.artist
              it.albumDescTv.text = details.album.wiki.summary
            }
          }
        }
        is Resource.Loading -> {
          showProgressBar()
        }
        is Resource.Error -> {
          hideProgressBar()
        }
        else -> {}
      }
    }

    viewModel.genre.observe({ lifecycle }) { response ->
      when (response) {
        is Resource.Success -> {
          hideProgressBar()
          response.data?.let {
            val genreList = it.toptags.tag.toTagItem()
            adapter.addAll(genreList)
          }
        }
        is Resource.Loading -> {
          showProgressBar()
        }
        is Resource.Error -> {
          hideProgressBar()
        }
        else -> {}
      }
    }
  }

  private fun List<Tag>.toTagItem(): List<TagItem> {
    return this.map {
      TagItem(it,
        onClick = { genreName ->
          findNavController().navigate(
            R.id.action_albumDetailsFragment_to_genreDetailsFragment,
            bundleOf("genreName" to genreName)
          )
        })
    }
  }

  private fun hideProgressBar() {
    binding?.loader?.root?.visibility = View.INVISIBLE
  }

  private fun showProgressBar() {
    binding?.loader?.root?.visibility = View.VISIBLE
  }

}