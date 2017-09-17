package com.example.jerome.kotlinimagesearch.model.repository

import android.arch.persistence.room.Room
import android.content.Context
import com.example.jerome.kotlinimagesearch.model.Document
import com.example.jerome.kotlinimagesearch.model.db.AppDatabase
import com.example.jerome.kotlinimagesearch.model.db.DocumentDao
import javax.inject.Inject

class ArchiveRepositoryImpl @Inject constructor(context: Context) : ArchiveRepository {

    private val documentDao: DocumentDao = Room
            .databaseBuilder(context, AppDatabase::class.java, "imageDb")
            .build()
            .getDocumentDao()

    override fun saveImage(image: Document) {
        documentDao.saveImage(image)
    }

    override fun getImages(): List<Document> {
        return documentDao.getImages()
    }

}