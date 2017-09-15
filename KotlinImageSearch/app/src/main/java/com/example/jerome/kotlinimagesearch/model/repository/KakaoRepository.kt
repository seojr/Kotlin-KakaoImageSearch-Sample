package com.example.jerome.kotlinimagesearch.model.repository

import com.example.jerome.kotlinimagesearch.model.Result
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Response

interface KakaoRepository {

    fun searchImage(page: Int, query: String): Observable<Result>

    fun download(url: String): Observable<Response<ResponseBody>>

}