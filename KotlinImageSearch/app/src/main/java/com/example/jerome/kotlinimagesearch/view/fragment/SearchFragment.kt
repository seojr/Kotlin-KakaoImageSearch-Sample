package com.example.jerome.kotlinimagesearch.view.fragment

import android.content.Intent
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuInflater
import com.example.jerome.kotlinimagesearch.R
import com.example.jerome.kotlinimagesearch.di.component.ApplicationComponent
import com.example.jerome.kotlinimagesearch.model.Image
import com.example.jerome.kotlinimagesearch.presenter.SearchPresenter
import com.example.jerome.kotlinimagesearch.view.listener.SimpleOnQueryTextListener
import javax.inject.Inject


class SearchFragment : BaseGridFragment() {

    @Inject lateinit var presenter: SearchPresenter

    override fun injectComponent(applicationComponent: ApplicationComponent) {
        applicationComponent.inject(this)
        presenter.view = this
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

    override fun onItemClick(image: Image, position: Int) {
        presenter.saveImage(image)
    }

    override fun onBottomReached() {
        presenter.searchMore()
    }

    fun notifySavedImage() {
        activity.sendBroadcast(Intent(ACTION_SAVED_IMAGE))
    }

}