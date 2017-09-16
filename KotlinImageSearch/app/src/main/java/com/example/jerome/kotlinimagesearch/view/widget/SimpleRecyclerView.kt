package com.example.jerome.kotlinimagesearch.view.widget

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet

class SimpleRecyclerView : RecyclerView {

    interface ReachedBottomListener {
        fun onBottomReached()
    }

    private var reachedBottomListener: ReachedBottomListener? = null

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

    override fun onFinishInflate() {
        super.onFinishInflate()
        setReachedBottomDetector()
    }

    fun setReachedBottomListener(reachedBottomListener: ReachedBottomListener) {
        this.reachedBottomListener = reachedBottomListener
    }

    private fun setReachedBottomDetector() {
        addOnScrollListener(object : OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                with(recyclerView) {
                    var visibleItemCount = childCount
                    val lm = layoutManager
                    var totalItemCount = lm.itemCount

                    var firstVisibleItemPosition = 0
                    when (lm) {
                        is GridLayoutManager -> firstVisibleItemPosition = lm.findFirstVisibleItemPosition()
                        is LinearLayoutManager -> firstVisibleItemPosition = lm.findFirstVisibleItemPosition()
                        // is StaggeredGridLayoutManager -> firstVisibleItemPosition = lm.findFirstVisibleItemPositions()
                    }

                    if (firstVisibleItemPosition + visibleItemCount >= totalItemCount) {
                        reachedBottomListener?.onBottomReached()
                    }
                }
            }
        })
    }
}