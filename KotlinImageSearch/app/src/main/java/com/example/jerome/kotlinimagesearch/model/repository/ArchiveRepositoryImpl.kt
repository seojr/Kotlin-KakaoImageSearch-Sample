package com.example.jerome.kotlinimagesearch.model.repository

import android.arch.persistence.room.Room
import android.content.Context
import com.example.jerome.kotlinimagesearch.model.Image
import com.example.jerome.kotlinimagesearch.model.db.AppDatabase
import com.example.jerome.kotlinimagesearch.model.db.ImageDao
import javax.inject.Inject

class ArchiveRepositoryImpl @Inject constructor(context: Context) : ArchiveRepository {

    private val imageDao: ImageDao = Room
            .databaseBuilder(context, AppDatabase::class.java, "imageDb")
            .build()
            .getImageDao()

    override fun saveImage(image: Image) {
        imageDao.saveImage(image)
    }

    override fun getImages(): List<Image> {
        return imageDao.getImages()
    }

}