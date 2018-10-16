package com.xrc.kotlinproject.presenter

import android.os.Handler
import com.xrc.kotlinproject.base.BasePresenter
import com.xrc.kotlinproject.view.IListView

/**
 * ListPresenter
 * Created by xrc on 18/10/15.
 */
class ListPresenter(view: IListView) : BasePresenter<IListView>(view) {
    fun requestInfo() {
        Handler().postDelayed({
            val random: Int = (Math.random() * 10).toInt()
            when (random) {
                in 0..3 -> {
                    mvpView?.success()
                }
                in 3..6 -> {
                    mvpView?.failed()
                }
                in 6..10 -> {
                    mvpView?.empty()
                }
            }
        }, 2000)
    }


}