package com.example.jerome.kotlinimagesearch.view.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.jerome.kotlinimagesearch.view.fragment.ArchiveFragment
import com.example.jerome.kotlinimagesearch.view.fragment.SearchFragment

class HomePagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "검색"
            else -> "보관함"
        }
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> SearchFragment()
            else -> ArchiveFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

}