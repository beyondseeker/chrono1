package com.objectfanatics.infra.androidx.recyclerview.widget

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.NO_POSITION

/**
 * This is a [LinearSnapHelper] tries to show the first or last visible item completely.
 */
class StartSnapHelper : LinearSnapHelper() {
    override fun calculateDistanceToFinalSnap(layoutManager: LayoutManager, targetView: View): IntArray =
        when {
            layoutManager.canScrollHorizontally() -> intArrayOf(distanceToLeft(layoutManager, targetView), 0)
            layoutManager.canScrollVertically() -> intArrayOf(0, distanceToTop(layoutManager, targetView))
            else -> throw newException(layoutManager)
        }

    override fun findSnapView(layoutManager: LayoutManager): View? {
        with(layoutManager as LinearLayoutManager) {
            val firstVisibleItemPos = findFirstVisibleItemPosition()

            if (isEmpty(firstVisibleItemPos) || isLastItemCompletelyVisible()) {
                return null
            }

            val firstVisibleItem = findViewByPosition(firstVisibleItemPos)

            getOrientationHelper(layoutManager).run {
                // Visible size of firstVisibleItem.
                val visibleSizeOfFirstVisibleItem = getDecoratedEnd(firstVisibleItem)

                // Size of firstVisibleItem.
                val wholeSizeOfFirstVisibleItem = getDecoratedMeasurement(firstVisibleItem)

                return when {
                    // Visible size of firstVisibleItem is greater than zero and greater than or equals to half of the whole size.
                    visibleSizeOfFirstVisibleItem > 0 && visibleSizeOfFirstVisibleItem >= wholeSizeOfFirstVisibleItem / 2 -> firstVisibleItem

                    // Visible size of firstVisibleItem is zero or less than half of the whole size.
                    else -> findViewByPosition(firstVisibleItemPos + 1)
                }
            }
        }
    }

    private fun horizontalHelper(layoutManager: LayoutManager): OrientationHelper =
        OrientationHelper.createHorizontalHelper(layoutManager)

    private fun verticalHelper(layoutManager: LayoutManager): OrientationHelper =
        OrientationHelper.createVerticalHelper(layoutManager)

    // The left of the view including its decoration, margin and padding.
    private fun distanceToLeft(layoutManager: LayoutManager, targetView: View): Int =
        horizontalHelper(layoutManager).run { getDecoratedStart(targetView) - startAfterPadding }

    // The top of the view including its decoration, margin and padding.
    private fun distanceToTop(layoutManager: LayoutManager, targetView: View): Int =
        verticalHelper(layoutManager).run { getDecoratedStart(targetView) - startAfterPadding }

    private fun isEmpty(firstItemPos: Int) = firstItemPos == NO_POSITION

    private fun LinearLayoutManager.isLastItemCompletelyVisible() =
        findLastCompletelyVisibleItemPosition() == itemCount - 1

    private fun getOrientationHelper(layoutManager: LinearLayoutManager): OrientationHelper = when {
        layoutManager.canScrollHorizontally() -> horizontalHelper(layoutManager)
        layoutManager.canScrollVertically() -> verticalHelper(layoutManager)
        else -> throw newException(layoutManager)
    }

    private fun newException(layoutManager: LayoutManager) =
        UnsupportedOperationException("Unexpected layoutManager: ${layoutManager.javaClass.name}")
}