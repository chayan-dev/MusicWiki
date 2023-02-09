package com.example.musicwiki.ui

import android.graphics.Color
import com.example.api.models.ArtistX
import com.example.api.models.TrackXXX
import com.example.musicwiki.R
import com.example.musicwiki.databinding.ItemAlbumBinding
import com.example.musicwiki.extensions.loadImage
import com.xwray.groupie.databinding.BindableItem

class TopTracksItem (
  private val track: TrackXXX
): BindableItem<ItemAlbumBinding>() {

  override fun bind(viewBinding: ItemAlbumBinding, position: Int) {
    viewBinding.coverIv.loadImage(track.image[1].text)
    viewBinding.titleTv.setTextColor(Color.parseColor("#000000"))
    viewBinding.descTv.setTextColor(Color.parseColor("#000000"))
    viewBinding.titleTv.text = track.name
    viewBinding.descTv.text = track.artist.name
  }

  override fun getLayout() = R.layout.item_album
}