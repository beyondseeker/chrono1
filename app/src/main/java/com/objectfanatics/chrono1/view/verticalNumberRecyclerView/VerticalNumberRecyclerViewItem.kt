package com.objectfanatics.chrono1.view.verticalNumberRecyclerView

import com.objectfanatics.chrono1.R
import com.objectfanatics.chrono1.databinding.ViewVerticalNumberRecyclerViewRowBinding
import com.xwray.groupie.databinding.BindableItem

class VerticalNumberRecyclerViewItem : BindableItem<ViewVerticalNumberRecyclerViewRowBinding>() {
    override fun getLayout(): Int = R.layout.view_vertical_number_recycler_view_row
    override fun bind(viewBinding: ViewVerticalNumberRecyclerViewRowBinding, position: Int) {
        viewBinding.text.text = position.toString()
    }
}