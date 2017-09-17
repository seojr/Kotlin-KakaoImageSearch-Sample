package com.example.jerome.kotlinimagesearch.model.repository

import com.example.jerome.kotlinimagesearch.model.Image

interface ArchiveRepository {

    fun saveImage(image: Image)

    fun getImages(): List<Image>

}