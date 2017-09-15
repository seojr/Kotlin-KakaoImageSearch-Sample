package com.example.jerome.kotlinimagesearch.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.jerome.kotlinimagesearch.R
import com.example.jerome.kotlinimagesearch.model.Document
import com.example.jerome.kotlinimagesearch.view.holder.ImageHolder

class ImageAdapter : BaseGridAdapter() {

    private val documents: ArrayList<Document> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        return ImageHolder(LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false))
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        holder.bind(documents[position])
    }

    override fun getItemCount(): Int {
        return documents.size
    }

    fun setImages(documents: List<Document>) {
        this.documents.clear()
        this.documents.addAll(documents)
        notifyDataSetChanged()
    }

    fun addImages(documents: List<Document>) {
        this.documents.addAll(documents)
        notifyDataSetChanged()
    }
}