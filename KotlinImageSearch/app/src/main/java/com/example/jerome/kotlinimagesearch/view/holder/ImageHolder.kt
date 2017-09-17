package com.example.jerome.kotlinimagesearch.view.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.example.jerome.kotlinimagesearch.model.Image
import kotlinx.android.synthetic.main.image_item.view.*

class ImageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(image: Image) {
        Glide.with(itemView.context)
                .load(image.thumbnailUrl)
                .into(itemView.image)
    }

}