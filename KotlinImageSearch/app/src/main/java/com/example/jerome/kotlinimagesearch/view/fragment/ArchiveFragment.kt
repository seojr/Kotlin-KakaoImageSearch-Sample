package com.example.jerome.kotlinimagesearch.view.fragment

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import com.example.jerome.kotlinimagesearch.di.component.ApplicationComponent
import com.example.jerome.kotlinimagesearch.model.Image
import com.example.jerome.kotlinimagesearch.presenter.ArchivePresenter
import javax.inject.Inject

class ArchiveFragment : BaseGridFragment() {

    @Inject lateinit var presenter: ArchivePresenter

    override fun injectComponent(applicationComponent: ApplicationComponent) {
        applicationComponent.inject(this)
        presenter.view = this
    }

    override fun initView() {
        presenter.loadImages()
        activity.registerReceiver(object: BroadcastReceiver() {
            override fun onReceive(p0: Context?, p1: Intent?) {
                presenter.loadImages()
            }
        }, IntentFilter(ACTION_SAVED_IMAGE))
    }

    override fun onItemClick(image: Image, position: Int) {
        presenter.deleteImage(image, position)
    }

}