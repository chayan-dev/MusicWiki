package com.example.musicwiki.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.musicwiki.MusicViewModel
import com.example.musicwiki.R
import com.example.musicwiki.databinding.FragmentGenreDetailsBinding
import com.example.musicwiki.repository.MusicRepository
import com.example.musicwiki.utils.Resource
import com.google.android.material.tabs.TabLayout

class GenreDetailsFragment : Fragment() {

  private var binding: FragmentGenreDetailsBinding? = null
  private lateinit var pager: ViewPager
  private lateinit var tab: TabLayout
  val args: GenreDetailsFragmentArgs by navArgs()
//  lateinit var detailsViewModel: DetailsViewModel
  val detailsViewModel: DetailsViewModel by activityViewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
//    val musicRepository = MusicRepository()
//    val viewModelProviderFactory = DetailsViewModelProviderFactory(musicRepository)
//    detailsViewModel = ViewModelProvider(this, viewModelProviderFactory).get(DetailsViewModel::class.java)

    binding = FragmentGenreDetailsBinding.inflate(inflater,container,false)
    return binding?.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val genreName = args.genreName
    detailsViewModel.getGenreDetails(genreName)

    detailsViewModel.genreDetails.observe({lifecycle}){ response->
      when(response){
        is Resource.Success -> {
          response.data?.let { details->
            binding?.let {
              it.genreNameTv.text = details.tag.name
              it.descTv.text = details.tag.wiki.summary
            }
          }
        }
        else -> {}
      }
    }

    binding?.let {
      pager = it.viewPager
      tab = it.tabs
    }
    val adapter = ViewPagerAdapter(childFragmentManager)

    adapter.addFragment(AlbumsFragment(genreName, onItemClick = { album,artist ->
      findNavController().navigate(
        R.id.action_genreDetailsFragment_to_albumDetailsFragment,
        bundleOf("albumName" to album, "artistName" to artist )
      )
    }),"Albums")

    adapter.addFragment(ArtistsFragment(genreName, onItemClick = { artist ->
      findNavController().navigate(
        R.id.action_genreDetailsFragment_to_artistDetailsFragment,
        bundleOf("artistName" to artist )
      )
    }),"Artists")

    adapter.addFragment(TracksFragment(genreName), "Tracks")

    pager.adapter = adapter
    tab.setupWithViewPager(pager)

  }

  override fun onDestroyView() {
    super.onDestroyView()
    binding = null
  }

}