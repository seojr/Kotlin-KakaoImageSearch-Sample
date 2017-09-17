package com.example.jerome.kotlinimagesearch.view.adapter

import android.support.v7.widget.RecyclerView
import com.example.jerome.kotlinimagesearch.view.holder.ImageHolder

abstract class BaseGridAdapter<T> : RecyclerView.Adapter<ImageHolder>() {

    val items: ArrayList<T> = ArrayList()

    var onClickListener: ((item: T, pos: Int) -> Unit)? = null

    override final fun onBindViewHolder(holder: ImageHolder, position: Int) {
        onBindHolder(holder, position)
        holder.itemView.setOnClickListener {
            onClickListener?.invoke(items[position], position)
        }
    }

    abstract fun onBindHolder(holder: ImageHolder, position: Int)

}