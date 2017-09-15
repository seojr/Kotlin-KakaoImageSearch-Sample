package com.example.jerome.kotlinimagesearch.view.activity

import android.os.Bundle
import com.example.jerome.kotlinimagesearch.R
import com.example.jerome.kotlinimagesearch.di.component.ApplicationComponent
import com.example.jerome.kotlinimagesearch.view.adapter.HomePagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : BaseActivity() {

    private lateinit var adapter: HomePagerAdapter

    companion object {
        private const val OFF_SCREEN_PAGE_LIMIT = 2
    }

    override fun injectComponent(applicationComponent: ApplicationComponent) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setToolbar()
        setViewPager()
        setTabs()
    }

    private fun setToolbar() {
        setSupportActionBar(toolbar)
    }

    private fun setViewPager() {
        adapter = HomePagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter
        viewPager.offscreenPageLimit = OFF_SCREEN_PAGE_LIMIT
    }

    private fun setTabs() {
        tabs.setupWithViewPager(viewPager)
    }

}