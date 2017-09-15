package com.example.jerome.kotlinimagesearch.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.jerome.kotlinimagesearch.App
import com.example.jerome.kotlinimagesearch.di.component.ApplicationComponent


abstract class BaseActivity: AppCompatActivity() {

    protected abstract fun injectComponent(applicationComponent: ApplicationComponent)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectComponent(getApplicationComponent())
    }

    private fun getApplicationComponent(): ApplicationComponent {
        return (application as App).applicationComponent
    }

}