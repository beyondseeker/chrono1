package com.objectfanatics.chrono1.view.horizontalNumberRecyclerView

import com.objectfanatics.chrono1.R
import com.objectfanatics.chrono1.databinding.ViewHorizontalNumberRecyclerViewRowBinding
import com.xwray.groupie.databinding.BindableItem

class HorizontalNumberRecyclerViewItem : BindableItem<ViewHorizontalNumberRecyclerViewRowBinding>() {
    override fun getLayout(): Int = R.layout.view_horizontal_number_recycler_view_row
    override fun bind(viewBinding: ViewHorizontalNumberRecyclerViewRowBinding, position: Int) {
        viewBinding.text.text = position.toString()
    }
}