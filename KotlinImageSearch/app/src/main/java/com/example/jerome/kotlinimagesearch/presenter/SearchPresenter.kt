package com.example.jerome.kotlinimagesearch.presenter

import android.widget.Toast
import com.example.jerome.kotlinimagesearch.model.Image
import com.example.jerome.kotlinimagesearch.model.repository.ArchiveRepositoryImpl
import com.example.jerome.kotlinimagesearch.model.repository.KakaoRepositoryImpl
import com.example.jerome.kotlinimagesearch.view.fragment.SearchFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SearchPresenter @Inject constructor(private var kakaoRepository: KakaoRepositoryImpl,
                                          private var archiveRepository: ArchiveRepositoryImpl) : BasePresenter<SearchFragment>() {

    private var loading: Boolean = false
    private var page: Int = 1
    private lateinit var query: String

    fun searchImage(query: String) {
        kakaoRepository.searchImage(page, query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { showLoading() }
                .doOnTerminate { hideLoading() }
                .subscribe({
                    this.query = query
                    page++
                    view?.setImages(it.images)
                }, {
                    view?.error()
                })
    }

    fun searchMore() {
        kakaoRepository.searchImage(page, query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { showLoading() }
                .doOnTerminate { hideLoading() }
                .subscribe({
                    page++
                    view?.addImages(it.images)
                }, {
                    view?.error()
                })
    }

    fun saveImage(image: Image) {
        archiveRepository.saveImage(image)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { showLoading() }
                .doOnComplete { hideLoading() }
                .subscribe({
                    Toast.makeText(view?.activity, "저장 성공", Toast.LENGTH_SHORT).show()
                    view?.notifySavedImage()
                }, {
                    Toast.makeText(view?.activity, "저장 실패", Toast.LENGTH_SHORT).show()
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