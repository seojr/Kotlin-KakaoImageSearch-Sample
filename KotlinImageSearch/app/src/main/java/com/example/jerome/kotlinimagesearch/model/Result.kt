package com.example.jerome.kotlinimagesearch.model

import com.google.gson.annotations.SerializedName

data class Result(var meta: Meta,
                  @SerializedName("documents") var images: List<Image>)