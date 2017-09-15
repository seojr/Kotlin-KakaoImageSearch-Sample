package com.example.jerome.kotlinimagesearch.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.example.jerome.kotlinimagesearch.App
import com.example.jerome.kotlinimagesearch.di.component.ApplicationComponent


abstract class BaseFragment : Fragment() {

    protected abstract fun injectComponent(applicationComponent: ApplicationComponent)

    protected abstract fun initView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectComponent(getApplicationComponent())
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun getApplicationComponent(): ApplicationComponent {
        return (activity.application as App).applicationComponent
    }

}