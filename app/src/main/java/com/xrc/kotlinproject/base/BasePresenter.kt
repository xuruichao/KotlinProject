package com.xrc.kotlinproject.base

import android.view.View
import android.view.ViewGroup
import com.xrc.kotlinproject.custom.MultiStateView

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

    fun findMultiStateView(view: View?): ViewGroup? {
        if (view is ViewGroup) {
            if (view is MultiStateView) {
                return view
            }
            for (i in 0 until view.childCount) {
                val child = view.getChildAt(i)
                if (child is ViewGroup) {
                    if (child is MultiStateView) {
                        return child
                    } else {
                        val multiStateView = findMultiStateView(child)
                        if (multiStateView != null) {
                            return multiStateView
                        }
                    }
                }

            }
        }
        return null
    }
}