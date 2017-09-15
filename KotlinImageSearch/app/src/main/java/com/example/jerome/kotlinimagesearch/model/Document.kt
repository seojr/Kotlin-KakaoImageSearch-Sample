package com.example.jerome.kotlinimagesearch.model

data class Document(var collection: String,
                    var thumbnailUrl: String,
                    var imageUrl: String,
                    var width: Int,
                    var height: Int,
                    var displaySitename: String,
                    var docUrl: String,
                    var datetime: String)