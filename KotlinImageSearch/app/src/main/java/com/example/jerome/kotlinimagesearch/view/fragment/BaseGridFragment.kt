package com.example.jerome.kotlinimagesearch.view.fragment

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.jerome.kotlinimagesearch.R
import com.example.jerome.kotlinimagesearch.model.Image
import com.example.jerome.kotlinimagesearch.view.adapter.ImageAdapter
import com.example.jerome.kotlinimagesearch.view.widget.SimpleRecyclerView
import kotlinx.android.synthetic.main.view_recycler.*

abstract class BaseGridFragment : BaseFragment() {

    companion object {
        private const val GRID_SPAN_COUNT: Int = 3
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

    fun showLoading() {
        progress.visibility = View.VISIBLE
    }

    fun hideLoading() {
        progress.visibility = View.GONE
    }

    fun error() {
        Toast.makeText(activity, "에러 발생", Toast.LENGTH_SHORT).show()
    }
}