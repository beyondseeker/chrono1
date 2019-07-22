package com.objectfanatics.chrono1.view.verticalNumberRecyclerView

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import com.objectfanatics.chrono1.view.numberRecyclerView.attach

class VerticalNumberRecyclerView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : RecyclerView(context, attrs, defStyleAttr) {
    init {
        attach(VERTICAL) { VerticalNumberRecyclerViewItem() }
    }
}