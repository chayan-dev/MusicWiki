package com.example.musicwiki.ui.recyclerviewItems

import com.example.api.models.Tag
import com.example.musicwiki.R
import com.example.musicwiki.databinding.GenreItemLayoutBinding
import com.example.musicwiki.databinding.TagItemLayoutBinding
import com.xwray.groupie.databinding.BindableItem

class TagItem(
  private val tag: Tag,
  val onClick: (genreName: String) -> Unit
) : BindableItem<GenreItemLayoutBinding>() {

  override fun bind(viewBinding: GenreItemLayoutBinding, position: Int) {
    viewBinding.root.setOnClickListener { onClick(tag.name) }
    viewBinding.tagNameTv.text = tag.name
  }

  override fun getLayout() = R.layout.genre_item_layout

}