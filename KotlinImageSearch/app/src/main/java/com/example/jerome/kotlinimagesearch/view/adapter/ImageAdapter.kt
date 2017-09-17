package com.example.jerome.kotlinimagesearch.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.jerome.kotlinimagesearch.R
import com.example.jerome.kotlinimagesearch.model.Image
import com.example.jerome.kotlinimagesearch.view.holder.ImageHolder

class ImageAdapter : BaseGridAdapter() {

    private val images: ArrayList<Image> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        return ImageHolder(LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false))
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        holder.bind(images[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }

    fun setImages(documents: List<Image>) {
        this.images.clear()
        this.images.addAll(documents)
        notifyDataSetChanged()
    }

    fun addImages(documents: List<Image>) {
        this.images.addAll(documents)
        notifyItemRangeInserted(this.images.size-documents.size, documents.size)
    }
}