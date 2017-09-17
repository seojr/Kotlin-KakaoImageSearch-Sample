package com.example.jerome.kotlinimagesearch.model.repository

import android.arch.persistence.room.Room
import android.content.Context
import com.example.jerome.kotlinimagesearch.model.Image
import com.example.jerome.kotlinimagesearch.model.db.AppDatabase
import com.example.jerome.kotlinimagesearch.model.db.ImageDao
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.functions.Action
import io.reactivex.internal.operators.completable.CompletableFromAction
import javax.inject.Inject

class ArchiveRepositoryImpl @Inject constructor(context: Context) : ArchiveRepository {

    private val imageDao: ImageDao = Room
            .databaseBuilder(context, AppDatabase::class.java, "imageDb")
            .build()
            .getImageDao()

    override fun saveImage(image: Image): Completable {
        return CompletableFromAction(Action {
            imageDao.saveImage(image)
        })
    }

    override fun getImages(): Single<List<Image>> = imageDao.getImages()

    override fun deleteImage(image: Image): Completable {
        return CompletableFromAction(Action {
            imageDao.deleteImage(image)
        })
    }
}