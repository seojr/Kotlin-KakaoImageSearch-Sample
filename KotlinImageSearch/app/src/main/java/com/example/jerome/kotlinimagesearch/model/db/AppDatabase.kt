package com.example.jerome.kotlinimagesearch.model.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.jerome.kotlinimagesearch.model.Image

@Database(entities = arrayOf(Image::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getImageDao(): ImageDao

}