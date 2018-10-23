package com.xrc.kotlinproject.base

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import com.xrc.kotlinproject.util.ToastUtil
import java.lang.ref.SoftReference

/**
 * BasePresenter
 * Created by xrc on 18/10/15.
 */
abstract class BasePresenter<V : IBaseView>(view: V) : IBasePresenter, LifecycleObserver {

    private var mvpViewHolder: SoftReference<V>? = SoftReference(view)
    var mvpView: V? = mvpViewHolder?.get()

    init {
        if (mvpView is LifecycleOwner) {
            @Suppress("LeakingThis")
            (mvpView as LifecycleOwner).lifecycle.addObserver(this)
            ToastUtil.showToast("attachView")
        }
    }

    override fun detachView() {
        mvpViewHolder?.clear()
        mvpViewHolder = null
        mvpView = null
        ToastUtil.showToast("detachView")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        detachView()
    }
}