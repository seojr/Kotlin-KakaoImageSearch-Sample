package com.example.jerome.kotlinimagesearch.view.fragment

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.SearchView
import android.view.*
import com.example.jerome.kotlinimagesearch.R
import com.example.jerome.kotlinimagesearch.di.component.ApplicationComponent
import com.example.jerome.kotlinimagesearch.model.Document
import com.example.jerome.kotlinimagesearch.presenter.SearchPresenter
import com.example.jerome.kotlinimagesearch.view.adapter.ImageAdapter
import com.example.jerome.kotlinimagesearch.view.listener.SimpleOnQueryTextListener
import com.example.jerome.kotlinimagesearch.view.widget.SimpleRecyclerView
import kotlinx.android.synthetic.main.view_recycler.*
import javax.inject.Inject


class SearchFragment : BaseFragment() {

    companion object {
        private const val GRID_SPAN_COUNT: Int = 3
    }

    private lateinit var imageAdapter: ImageAdapter
    @Inject lateinit var presenter: SearchPresenter

    override fun injectComponent(applicationComponent: ApplicationComponent) {
        applicationComponent.inject(this)
        presenter.view = this
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.view_recycler, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search, menu)
        var searchView: SearchView = menu.getItem(0).actionView as SearchView
        searchView.setOnQueryTextListener(object : SimpleOnQueryTextListener() {
            override fun onQueryTextSubmit(query: String): Boolean {
                presenter.searchImage(query)
                return false
            }
        })
    }

    override fun initView() {
        with(recyclerView) {
            layoutManager = GridLayoutManager(context, GRID_SPAN_COUNT)
            imageAdapter = ImageAdapter()
            adapter = imageAdapter
            setReachedBottomListener(object: SimpleRecyclerView.ReachedBottomListener {
                override fun onBottomReached() {
                    presenter.searchMore()
                }
            })
        }
    }

    fun setImages(images: List<Document>) {
        imageAdapter.setImages(images)
    }

    fun addImages(images: List<Document>) {
        imageAdapter.addImages(images)
    }

    fun showLoading() {
        progress.visibility = View.VISIBLE
    }

    fun hideLoading() {
        progress.visibility = View.GONE
    }

    fun error() {
        Snackbar.make(recyclerView, "에러 발생", Snackbar.LENGTH_SHORT).show()
    }

}