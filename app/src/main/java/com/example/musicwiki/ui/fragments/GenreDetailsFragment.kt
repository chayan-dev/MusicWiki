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
import androidx.viewpager.widget.ViewPager
import com.example.musicwiki.R
import com.example.musicwiki.databinding.FragmentGenreDetailsBinding
import com.example.musicwiki.ui.viewmodels.DetailsViewModel
import com.example.musicwiki.utils.Resource
import com.google.android.material.tabs.TabLayout

class GenreDetailsFragment : Fragment() {

  private var binding: FragmentGenreDetailsBinding? = null
  private lateinit var pager: ViewPager
  private lateinit var tab: TabLayout
  val args: GenreDetailsFragmentArgs by navArgs()
  val detailsViewModel: DetailsViewModel by activityViewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentGenreDetailsBinding.inflate(inflater, container, false)
    return binding?.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val genreName = args.genreName
    detailsViewModel.getGenreDetails(genreName)
    detailsViewModel.getGenre()

    detailsViewModel.genreDetails.observe({ lifecycle }) { response ->
      when (response) {
        is Resource.Success -> {
          hideProgressBar()
          response.data?.let { details ->
            binding?.let {
              it.genreNameTv.text = details.tag.name
              it.descTv.text = details.tag.wiki.summary
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

    binding?.let {
      pager = it.viewPager
      tab = it.tabs
    }
    val adapter = ViewPagerAdapter(childFragmentManager)

    adapter.addFragment(AlbumsFragment(genreName, onItemClick = { album, artist ->
      findNavController().navigate(
        R.id.action_genreDetailsFragment_to_albumDetailsFragment,
        bundleOf("albumName" to album, "artistName" to artist)
      )
    }), "Albums")

    adapter.addFragment(ArtistsFragment(genreName, onItemClick = { artist ->
      findNavController().navigate(
        R.id.action_genreDetailsFragment_to_artistDetailsFragment,
        bundleOf("artistName" to artist)
      )
    }), "Artists")

    adapter.addFragment(TracksFragment(genreName), "Tracks")

    pager.adapter = adapter
    tab.setupWithViewPager(pager)

  }

  private fun hideProgressBar() {
    binding?.loader?.root?.visibility = View.INVISIBLE
  }

  private fun showProgressBar() {
    binding?.loader?.root?.visibility = View.VISIBLE
  }

  override fun onDestroyView() {
    super.onDestroyView()
    binding = null
  }

}