package com.example.jerome.kotlinimagesearch.model.repository

import com.example.jerome.kotlinimagesearch.model.Result
import com.example.jerome.kotlinimagesearch.model.api.KakaoApi
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class KakaoRepositoryImpl @Inject constructor(private var kakaoApi: KakaoApi): KakaoRepository {

    override fun searchImage(page: Int, query: String): Observable<Result> {
        return kakaoApi.searchImage(page, query)
    }

    override fun download(url: String): Observable<Response<ResponseBody>> {
        return kakaoApi.download(url)
    }
}