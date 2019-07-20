package com.objectfanatics.chrono1.view.horizontalNumberRecyclerView

import android.content.Context
import android.util.AttributeSet
import com.objectfanatics.chrono1.view.numberRecyclerView.NumberRecyclerView
import com.xwray.groupie.Group

class HorizontalNumberRecyclerView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : NumberRecyclerView(HORIZONTAL, ::newRecyclerViewItem, context, attrs, defStyleAttr) {
    companion object {
        private fun newRecyclerViewItem(): Group = HorizontalNumberRecyclerViewItem()
    }
}