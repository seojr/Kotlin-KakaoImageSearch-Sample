package com.example.jerome.kotlinimagesearch.model.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.jerome.kotlinimagesearch.model.Document

@Dao
interface DocumentDao {

    @Insert
    fun saveImage(image: Document)

    @Query("SELECT * FROM images")
    fun getImages(): List<Document>

}