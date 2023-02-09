package com.example.musicwiki.ui

import com.example.api.models.Album
import com.example.musicwiki.R
import com.example.musicwiki.databinding.ItemAlbumBinding
import com.xwray.groupie.databinding.BindableItem

class AlbumItem (
  private val album: Album,
  val onClick: (albumName: String, artistName:String ) -> Unit
): BindableItem<ItemAlbumBinding>() {

  override fun bind(viewBinding: ItemAlbumBinding, position: Int) {
    viewBinding.root.setOnClickListener { onClick(album.name, album.artist.name) }
    viewBinding.titleTv.text = album.name
    viewBinding.descTv.text = album.artist.name
  }

  override fun getLayout() = R.layout.item_album

}