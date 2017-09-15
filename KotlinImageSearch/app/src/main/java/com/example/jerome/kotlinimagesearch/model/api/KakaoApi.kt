package com.example.jerome.kotlinimagesearch.model.api

import com.example.jerome.kotlinimagesearch.model.Result
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface KakaoApi {

    @GET("search/image")
    fun searchImage(@Query("page") page: Int, @Query("query") query: String): Observable<Result>

    @GET
    fun download(@Url url: String): Observable<Response<ResponseBody>>

}