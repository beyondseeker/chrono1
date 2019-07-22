package com.objectfanatics.chrono1.view.horizontalNumberRecyclerView

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import com.objectfanatics.chrono1.view.numberRecyclerView.attach

class HorizontalNumberRecyclerView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : RecyclerView(context, attrs, defStyleAttr) {
    init {
        attach(HORIZONTAL) { HorizontalNumberRecyclerViewItem() }
    }
}