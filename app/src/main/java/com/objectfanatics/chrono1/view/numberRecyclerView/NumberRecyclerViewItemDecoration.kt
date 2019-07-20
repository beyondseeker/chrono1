package com.objectfanatics.chrono1.view.numberRecyclerView

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*

class NumberRecyclerViewItemDecoration(context: Context) : ItemDecoration() {
    private val gap: Int = (GAP_DP * context.resources.displayMetrics.density).toInt()

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, @Suppress("RemoveRedundantQualifierName") state: RecyclerView.State) {
        if (parent.getChildLayoutPosition(view) < parent.adapter!!.itemCount - 1) {
            when ((parent.layoutManager as LinearLayoutManager).orientation) {
                VERTICAL -> outRect.bottom = gap
                HORIZONTAL -> outRect.right = gap
                else -> throw UnsupportedOperationException()
            }
        }
    }

    companion object {
        const val GAP_DP: Int = 1
    }
}