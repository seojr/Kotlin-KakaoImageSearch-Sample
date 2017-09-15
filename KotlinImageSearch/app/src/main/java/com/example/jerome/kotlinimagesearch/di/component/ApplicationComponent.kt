package com.example.jerome.kotlinimagesearch.di.component

import com.example.jerome.kotlinimagesearch.di.module.AndroidModule
import com.example.jerome.kotlinimagesearch.di.module.RetrofitModule
import com.example.jerome.kotlinimagesearch.view.fragment.ArchiveFragment
import com.example.jerome.kotlinimagesearch.view.fragment.SearchFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidModule::class, RetrofitModule::class))
interface ApplicationComponent {

    fun inject(searchFragment: SearchFragment)

    fun inject(archiveFragment: ArchiveFragment)

}