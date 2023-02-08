package com.example.musicwiki.ui

import com.example.api.models.Track
import com.example.musicwiki.R
import com.example.musicwiki.databinding.ItemAlbumBinding
import com.xwray.groupie.databinding.BindableItem

class TracksItem (
  private val track: Track,
  val onClick: (genreName: String) -> Unit
): BindableItem<ItemAlbumBinding>() {

  override fun bind(viewBinding: ItemAlbumBinding, position: Int) {
    viewBinding.root.setOnClickListener { onClick(track.name) }
    viewBinding.titleTv.text = track.name
    viewBinding.descTv.text = track.artist.name
  }

  override fun getLayout() = R.layout.item_album

}