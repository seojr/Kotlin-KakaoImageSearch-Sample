package com.example.jerome.kotlinimagesearch.util.extension

import android.view.View

inline fun View.show() {
    visibility = View.VISIBLE
}

inline fun View.hide() {
    visibility = View.GONE
}

