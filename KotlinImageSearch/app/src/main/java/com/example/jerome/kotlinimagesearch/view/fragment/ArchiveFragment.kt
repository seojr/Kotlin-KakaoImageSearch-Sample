package com.example.jerome.kotlinimagesearch.view.fragment

import com.example.jerome.kotlinimagesearch.di.component.ApplicationComponent
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
    }

}