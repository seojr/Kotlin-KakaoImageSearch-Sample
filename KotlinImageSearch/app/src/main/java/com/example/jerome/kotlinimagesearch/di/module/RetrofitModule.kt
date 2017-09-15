package com.example.jerome.kotlinimagesearch.di.module

import com.example.jerome.kotlinimagesearch.BuildConfig
import com.example.jerome.kotlinimagesearch.model.api.KakaoApi
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://dapi.kakao.com/v2/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient)
                .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
        httpClient.addInterceptor({ chain ->
            val original: Request = chain.request()
            val request: Request = original.newBuilder()
                    .header("Authorization", "KakaoAK " + BuildConfig.API_KEY)
                    .method(original.method(), original.body())
                    .build()
            chain.proceed(request)
        })

        return httpClient.build()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
    }

    @Provides
    @Singleton
    fun provideKakaoApi(retrofit: Retrofit): KakaoApi {
        return retrofit.create(KakaoApi::class.java)
    }

}