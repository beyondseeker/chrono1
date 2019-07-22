package com.objectfanatics.chrono1.view.numberRecyclerView

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.objectfanatics.infra.androidx.recyclerview.widget.StartSnapHelper
import com.xwray.groupie.Group
import com.xwray.groupie.GroupAdapter

const val ITEM_NUM: Int = 10

fun RecyclerView.attach(orientation: Int, groupFactory: () -> Group) {
    layoutManager = LinearLayoutManager(context).apply { this.orientation = orientation }
    addItemDecoration(NumberRecyclerViewItemDecoration(context))
    StartSnapHelper().attachToRecyclerView(this)
    adapter = GroupAdapter<com.xwray.groupie.ViewHolder>().apply {
        repeat(ITEM_NUM) { add(groupFactory()) }
    }
}