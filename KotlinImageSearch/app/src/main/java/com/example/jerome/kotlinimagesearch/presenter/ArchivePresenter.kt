package com.example.jerome.kotlinimagesearch.presenter

import com.example.jerome.kotlinimagesearch.model.repository.ArchiveRepositoryImpl
import com.example.jerome.kotlinimagesearch.view.fragment.ArchiveFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ArchivePresenter @Inject constructor(private var archiveRepository: ArchiveRepositoryImpl) : BasePresenter<ArchiveFragment>() {

    private var loading: Boolean = false

    fun loadImages() {
        archiveRepository.getImages()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe{ showLoading() }
                .doOnEvent( {_, _ -> hideLoading() })
                .subscribe ({
                    view?.setImages(it)
                }, {
                    // error
                })
    }

    private fun showLoading() {
        loading = true
        view?.showLoading()
    }

    private fun hideLoading() {
        loading = false
        view?.hideLoading()
    }

}