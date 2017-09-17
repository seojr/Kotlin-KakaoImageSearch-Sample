package com.example.jerome.kotlinimagesearch.model.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.jerome.kotlinimagesearch.model.Image
import io.reactivex.Single

@Dao
interface ImageDao {

    @Insert
    fun saveImage(image: Image)

    @Query("SELECT * FROM images")
    fun getImages(): Single<List<Image>>

    @Delete
    fun deleteImage(image: Image)
}