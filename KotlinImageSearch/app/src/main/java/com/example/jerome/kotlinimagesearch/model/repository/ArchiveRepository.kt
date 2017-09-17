package com.example.jerome.kotlinimagesearch.model.repository

import com.example.jerome.kotlinimagesearch.model.Document

interface ArchiveRepository {

    fun saveImage(image: Document)

    fun getImages(): List<Document>

}