package com.example.jerome.kotlinimagesearch.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.jerome.kotlinimagesearch.R
import com.example.jerome.kotlinimagesearch.model.Image
import com.example.jerome.kotlinimagesearch.view.holder.ImageHolder

class ImageAdapter : BaseGridAdapter<Image>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        return ImageHolder(LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false))
    }

    override fun onBindHolder(holder: ImageHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setImages(documents: List<Image>) {
        this.items.clear()
        this.items.addAll(documents)
        notifyDataSetChanged()
    }

    fun addImages(documents: List<Image>) {
        this.items.addAll(documents)
        notifyItemRangeInserted(this.items.size-documents.size, documents.size)
    }
}