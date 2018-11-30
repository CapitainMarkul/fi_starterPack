package sbis.helpers.view

import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

class ItemListDecorator(
    private val divider: Drawable,
    private val drawLastDivider: Boolean = false
) : RecyclerView.ItemDecoration() {

    private val ATTRS = intArrayOf(android.R.attr.listDivider)

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State?) {
        if (getOrientation(parent) == LinearLayoutManager.VERTICAL) drawVertical(c, parent)
        else drawHorizontal(c, parent)
    }


    private fun drawVertical(c: Canvas, parent: RecyclerView) {
        val manager = parent.layoutManager
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        val childCount = if (drawLastDivider) parent.childCount + 1 else parent.childCount
        for (i in 0 until childCount - 1) {
            val child = parent.getChildAt(i)

            val top = manager.getDecoratedBottom(child)
            val bottom = top + divider.intrinsicHeight

            divider.setBounds(left, top, right, bottom)
            divider.draw(c)
        }
    }

    private fun drawHorizontal(c: Canvas, parent: RecyclerView) {
        val top = parent.paddingTop
        val bottom = parent.height - parent.paddingBottom

        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            val params = child
                .layoutParams as RecyclerView.LayoutParams
            val left = child.right + params.rightMargin
            val right = left + divider.intrinsicHeight
            divider.setBounds(left, top, right, bottom)
            divider.draw(c)
        }
    }


    private fun getOrientation(parent: RecyclerView): Int {
        if (parent.layoutManager is LinearLayoutManager) {
            val layoutManager = parent.layoutManager as LinearLayoutManager
            return layoutManager.orientation
        } else {
            throw IllegalStateException("DividerItemDecoration can only be used with a LinearLayoutManager.")
        }
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)
        if (parent.getChildAdapterPosition(view) < 1) return

        if (getOrientation(parent) == LinearLayoutManager.VERTICAL) outRect.top = divider.intrinsicHeight
        else outRect.left = divider.intrinsicWidth
    }
}