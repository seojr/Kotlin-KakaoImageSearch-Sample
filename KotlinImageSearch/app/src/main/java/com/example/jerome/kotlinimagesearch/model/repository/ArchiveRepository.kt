package com.example.jerome.kotlinimagesearch.model.repository

import com.example.jerome.kotlinimagesearch.model.Image
import io.reactivex.Completable
import io.reactivex.Single

interface ArchiveRepository {

    fun saveImage(image: Image): Completable

    fun getImages(): Single<List<Image>>

}