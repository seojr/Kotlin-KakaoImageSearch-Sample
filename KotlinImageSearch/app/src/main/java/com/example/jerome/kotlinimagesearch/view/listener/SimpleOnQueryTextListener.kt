package com.example.jerome.kotlinimagesearch.view.listener

import android.support.v7.widget.SearchView

abstract class SimpleOnQueryTextListener : SearchView.OnQueryTextListener {

    abstract override fun onQueryTextSubmit(query: String): Boolean

    override fun onQueryTextChange(newText: String): Boolean {
        return false
    }

}