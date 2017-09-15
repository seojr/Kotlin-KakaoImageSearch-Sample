package com.example.jerome.kotlinimagesearch.view.adapter

import android.support.v7.widget.RecyclerView
import com.example.jerome.kotlinimagesearch.view.holder.ImageHolder

abstract class BaseGridAdapter : RecyclerView.Adapter<ImageHolder>() {

    var onClickListener: ((pos: Int) -> Unit)? = null

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        holder.itemView.setOnClickListener {
            onClickListener?.invoke(holder.adapterPosition)
        }
    }

}