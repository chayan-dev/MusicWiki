package com.example.musicwiki.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.api.models.Tag
import com.example.musicwiki.ui.viewmodels.MusicViewModel
import com.example.musicwiki.R
import com.example.musicwiki.databinding.FragmentHomeBinding
import com.example.musicwiki.repository.MusicRepository
import com.example.musicwiki.ui.recyclerviewItems.GenreItem
import com.example.musicwiki.ui.viewmodels.MusicViewModelProviderFactory
import com.example.musicwiki.utils.Resource
import com.xwray.groupie.GroupieAdapter

class HomeFragment : Fragment() {

  private var binding: FragmentHomeBinding? = null
  lateinit var musicViewModel: MusicViewModel

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val musicRepository = MusicRepository()
    val viewModelProviderFactory = MusicViewModelProviderFactory(musicRepository)
    musicViewModel =
      ViewModelProvider(this, viewModelProviderFactory).get(MusicViewModel::class.java)
    binding = FragmentHomeBinding.inflate(inflater, container, false)

    return binding?.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    musicViewModel.getGenre()

    val adapter = GroupieAdapter()
    binding?.tagsRv?.adapter = adapter

    musicViewModel.genre.observe({ lifecycle }) { response ->
      when (response) {
        is Resource.Success -> {
          hideProgressBar()
          response.data?.let {
            val genreList = it.toptags.tag.toGenreItem()
            adapter.clear()
            adapter.addAll(genreList.slice(0..11))
            binding?.let { binding ->
              binding.expandBtn.setOnClickListener {
                binding.expandBtn.setImageResource(R.drawable.ic_arrow_down)
                adapter.updateAsync(genreList)
              }
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
  }

  private fun List<Tag>.toGenreItem(): List<GenreItem> {
    return this.map {
      GenreItem(it,
        onClick = { genreName ->
          findNavController().navigate(
            R.id.action_homeFragment_to_genreDetailsFragment,
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