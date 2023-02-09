package com.example.musicwiki.ui

import com.example.api.models.ArtistX
import com.example.musicwiki.R
import com.example.musicwiki.databinding.ItemAlbumBinding
import com.xwray.groupie.databinding.BindableItem

class ArtistItem(
  private val artist: ArtistX,
  val onClick: (artistName: String) -> Unit
): BindableItem<ItemAlbumBinding>() {

  override fun bind(viewBinding: ItemAlbumBinding, position: Int) {
    viewBinding.root.setOnClickListener { onClick(artist.name) }
    viewBinding.titleTv.text = artist.name
    viewBinding.descTv.text = ""
  }

  override fun getLayout() = R.layout.item_album
}