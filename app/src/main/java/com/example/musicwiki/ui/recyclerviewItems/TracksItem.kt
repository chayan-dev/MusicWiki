package com.example.musicwiki.ui.recyclerviewItems

import android.graphics.Color
import androidx.core.content.ContextCompat
import com.example.api.models.Track
import com.example.musicwiki.R
import com.example.musicwiki.databinding.ItemAlbumBinding
import com.example.musicwiki.extensions.loadImage
import com.xwray.groupie.databinding.BindableItem

class TracksItem(
  private val track: Track
) : BindableItem<ItemAlbumBinding>() {

  override fun bind(viewBinding: ItemAlbumBinding, position: Int) {
    viewBinding.coverIv.loadImage(track.image[1].text)
    viewBinding.titleTv.setTextColor(Color.parseColor("#000000"))
    viewBinding.descTv.setTextColor(Color.parseColor("#000000"))
    viewBinding.titleTv.text = track.name
    viewBinding.descTv.text = track.artist.name
  }

  override fun getLayout() = R.layout.item_album

}