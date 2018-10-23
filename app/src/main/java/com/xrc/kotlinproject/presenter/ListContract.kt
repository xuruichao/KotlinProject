package com.xrc.kotlinproject.presenter

import com.xrc.kotlinproject.base.IBasePresenter
import com.xrc.kotlinproject.base.IBaseView

/**
 * ListContract
 * Created by xrc on 18/10/23.
 */
interface ListContract {

    interface View : IBaseView {
        fun success()
        fun failed()
        fun empty()
    }

    interface Presenter : IBasePresenter {
        fun requestInfo()
    }
}