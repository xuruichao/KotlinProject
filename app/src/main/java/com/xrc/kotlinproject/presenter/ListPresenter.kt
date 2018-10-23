package com.xrc.kotlinproject.presenter

import android.os.Handler
import com.xrc.kotlinproject.base.BasePresenter

/**
 * ListPresenter
 * Created by xrc on 18/10/15.
 */
class ListPresenter(view: ListContract.View) : BasePresenter<ListContract.View>(view), ListContract.Presenter {
    override fun requestInfo() {
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