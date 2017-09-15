package com.example.jerome.kotlinimagesearch

import android.app.Application
import com.example.jerome.kotlinimagesearch.di.component.ApplicationComponent
import com.example.jerome.kotlinimagesearch.di.component.DaggerApplicationComponent
import com.example.jerome.kotlinimagesearch.di.module.AndroidModule
import com.example.jerome.kotlinimagesearch.di.module.RetrofitModule

class App : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        initializeInjector()
    }

    private fun initializeInjector() {
        applicationComponent = DaggerApplicationComponent.builder()
                .androidModule(AndroidModule(this))
                .retrofitModule(RetrofitModule())
                .build()
    }

}