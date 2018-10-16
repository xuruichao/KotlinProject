package com.xrc.kotlinproject.base

/**
 * BasePresenter
 * Created by xrc on 18/10/15.
 */
abstract class BasePresenter<V : IBaseView>(view: V) {
    var mvpView: V? = null

    init {
        mvpView = view
    }

    fun detach() {
        mvpView = null
    }
}