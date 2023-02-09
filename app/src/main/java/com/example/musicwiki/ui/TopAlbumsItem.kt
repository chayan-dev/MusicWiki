package com.example.musicwiki.ui

import com.example.api.models.AlbumXXX
import com.example.api.models.TrackXXX
import com.example.musicwiki.R
import com.example.musicwiki.databinding.ItemAlbumBinding
import com.example.musicwiki.extensions.loadImage
import com.xwray.groupie.databinding.BindableItem

class TopAlbumsItem(
  private val album: AlbumXXX
): BindableItem<ItemAlbumBinding>() {

  override fun bind(viewBinding: ItemAlbumBinding, position: Int) {
    viewBinding.coverIv.loadImage(album.image[1].text)
    viewBinding.titleTv.text = album.name
    viewBinding.descTv.text = album.artist.name
  }

  override fun getLayout() = R.layout.item_album
}