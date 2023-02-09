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
import com.example.api.models.Album
import com.example.api.models.Tag
import com.example.musicwiki.R
import com.example.musicwiki.databinding.FragmentAlbumsBinding
import com.example.musicwiki.utils.Resource
import com.xwray.groupie.GroupieAdapter

class AlbumsFragment(
  val genreName: String,
  val onItemClick: (albumName: String, artistName:String ) -> Unit
) : Fragment() {

  private var binding: FragmentAlbumsBinding? = null
//  val detailsViewModel by viewModels<DetailsViewModel>({requireParentFragment()})
  val detailsViewModel: DetailsViewModel by activityViewModels()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    binding = FragmentAlbumsBinding.inflate(inflater,container,false)
    return binding?.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    detailsViewModel.getTopAlbums(genreName)

    val adapter = GroupieAdapter()
    binding?.albumRv?.adapter = adapter

    detailsViewModel.topAlbums.observe({lifecycle}){ response->
      when(response){
        is Resource.Success -> {
          response.data?.let {
            val albumList = it.albums.album.toAlbumItem()
            adapter.addAll(albumList)
          }
        }
        else -> {}
      }
    }
  }

  private fun List<Album>.toAlbumItem(): List<AlbumItem>{
    return this.map {
      AlbumItem(it,
        onClick = {albumName, artistName ->
          onItemClick(albumName, artistName)
        })
    }
  }

}