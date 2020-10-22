package com.example.yippiquiz.presenter

import android.util.Log
import com.example.yippiquiz.api.ApiServiceInterface
import com.example.yippiquiz.contract.MainContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainPresenter: MainContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private lateinit var view: MainContract.View
    private val apiSevices: ApiServiceInterface = ApiServiceInterface.create()

    override fun getList() {
        val subscribe = apiSevices.getList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("DOMAIN", it.toString())
                // view.onProgress(false)
                view.onDomainSuccess(it)
            }, { error ->
                var msg = error.localizedMessage
                view.onDomainError(msg)
            })
        subscriptions.add(subscribe)
    }



    override fun subscribe() {

    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: MainContract.View) {
        this.view = view
    }

}