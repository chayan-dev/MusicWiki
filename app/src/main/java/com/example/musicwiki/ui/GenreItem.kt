package com.example.musicwiki.ui

import com.example.api.models.Tag
import com.example.musicwiki.R
import com.example.musicwiki.databinding.TagItemLayoutBinding
import com.xwray.groupie.databinding.BindableItem

class GenreItem(
  private val tag:Tag,
  val onClick: (genreName: String) -> Unit
): BindableItem<TagItemLayoutBinding>() {

  override fun bind(viewBinding: TagItemLayoutBinding, position: Int) {
      viewBinding.root.setOnClickListener { onClick(tag.name) }
     viewBinding.tagNameTv.text = tag.name
  }

  override fun getLayout() = R.layout.tag_item_layout

}