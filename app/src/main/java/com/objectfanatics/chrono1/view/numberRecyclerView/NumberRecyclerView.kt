package com.objectfanatics.chrono1.view.numberRecyclerView

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.Group
import com.xwray.groupie.GroupAdapter

abstract class NumberRecyclerView @JvmOverloads constructor(orientation: Int, groupFactory: () -> Group, context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : RecyclerView(context, attrs, defStyleAttr) {
    init {
        layoutManager = LinearLayoutManager(context).apply { this.orientation = orientation }
        addItemDecoration(NumberRecyclerViewItemDecoration(context))
        adapter = GroupAdapter<com.xwray.groupie.ViewHolder>().apply {
            repeat(ITEM_NUM) {
                add(groupFactory())
            }
        }
    }
}