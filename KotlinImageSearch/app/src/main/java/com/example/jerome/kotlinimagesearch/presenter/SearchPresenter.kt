package com.example.jerome.kotlinimagesearch.presenter

import com.example.jerome.kotlinimagesearch.model.repository.KakaoRepositoryImpl
import com.example.jerome.kotlinimagesearch.view.fragment.SearchFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SearchPresenter @Inject constructor(var kakaoRepository: KakaoRepositoryImpl): BasePresenter<SearchFragment>() {

    private var loading: Boolean = false

    private var page: Int = 1
    private lateinit var query: String

    fun searchImage(query: String) {
        kakaoRepository.searchImage(page, query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe({view?.showLoading()})
                .doOnTerminate({
                    loading = false
                    view?.hideLoading()
                })
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
                .doOnSubscribe({view?.showLoading()})
                .doOnTerminate({
                    loading = false
                    view?.hideLoading()
                })
                .subscribe({
                    page++
                    view?.addImages(it.images)
                }, {
                    view?.error()
                })
    }

}