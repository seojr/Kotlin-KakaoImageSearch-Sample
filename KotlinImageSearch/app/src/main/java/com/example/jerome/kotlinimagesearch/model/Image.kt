package com.example.jerome.kotlinimagesearch.model

import android.arch.persistence.room.Dao
import android.arch.persistence.room.PrimaryKey

@Dao
data class Image(var collection: String,
                 var thumbnailUrl: String,
                 var imageUrl: String,
                 var width: Int,
                 var height: Int,
                 var displaySitename: String,
                 var docUrl: String,
                 var datetime: String) {

    @PrimaryKey(autoGenerate = true)
    var uid: Long = 0

}