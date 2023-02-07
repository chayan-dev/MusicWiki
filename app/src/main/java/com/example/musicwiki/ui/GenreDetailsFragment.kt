package com.example.musicwiki.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.musicwiki.R
import com.example.musicwiki.databinding.FragmentGenreDetailsBinding
import com.google.android.material.tabs.TabLayout

class GenreDetailsFragment : Fragment() {

  private var binding: FragmentGenreDetailsBinding? = null
  private lateinit var pager: ViewPager // creating object of ViewPager
  private lateinit var tab: TabLayout

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentGenreDetailsBinding.inflate(inflater,container,false)
    return binding?.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding?.let {
      pager = it.viewPager
      tab = it.tabs
    }
    val adapter = ViewPagerAdapter(childFragmentManager)
    adapter.addFragment(AlbumsFragment(),"Albums")
    adapter.addFragment(ArtistsFragment(),"Artists")
    adapter.addFragment(TracksFragment(), "Tracks")

    pager.adapter = adapter
    tab.setupWithViewPager(pager)

  }

  override fun onDestroyView() {
    super.onDestroyView()
    binding = null
  }

}