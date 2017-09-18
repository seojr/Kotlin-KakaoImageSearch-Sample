package com.example.jerome.kotlinimagesearch.view.fragment

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.jerome.kotlinimagesearch.R
import com.example.jerome.kotlinimagesearch.model.Image
import com.example.jerome.kotlinimagesearch.util.extension.hide
import com.example.jerome.kotlinimagesearch.util.extension.show
import com.example.jerome.kotlinimagesearch.view.adapter.ImageAdapter
import com.example.jerome.kotlinimagesearch.view.widget.SimpleRecyclerView
import kotlinx.android.synthetic.main.view_recycler.*

abstract class BaseGridFragment : BaseFragment() {

    companion object {
        private const val GRID_SPAN_COUNT: Int = 3
        const val ACTION_SAVED_IMAGE: String = "SavedImage"
    }

    private lateinit var imageAdapter: ImageAdapter

    override final fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.view_recycler, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBaseView()
    }

    private fun initBaseView() {
        with(recyclerView) {
            layoutManager = GridLayoutManager(context, GRID_SPAN_COUNT)
            imageAdapter = ImageAdapter()
            adapter = imageAdapter
            imageAdapter.onClickListener = { image: Image, position: Int ->
                onItemClick(image, position)
            }
            setReachedBottomListener(object : SimpleRecyclerView.ReachedBottomListener {
                override fun onBottomReached() {
                    this@BaseGridFragment.onBottomReached()
                }
            })
        }
        initView()
    }

    open fun initView() {
        // implement needed
    }

    open fun onItemClick(image: Image, position: Int) {
        // implement needed
    }

    open fun onBottomReached() {
        // implement needed
    }

    fun setImages(images: List<Image>) {
        imageAdapter.setImages(images)
    }

    fun addImages(images: List<Image>) {
        imageAdapter.addImages(images)
    }

    fun removeImage(position: Int) {
        imageAdapter.removeImage(position)
    }

    fun showLoading() {
        progress.show()
    }

    fun hideLoading() {
        progress.hide()
    }

    fun error() {
        Toast.makeText(activity, "에러 발생", Toast.LENGTH_SHORT).show()
    }
}