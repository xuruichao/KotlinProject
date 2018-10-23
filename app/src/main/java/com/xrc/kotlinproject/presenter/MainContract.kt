package com.xrc.kotlinproject.presenter

import com.xrc.kotlinproject.base.IBasePresenter
import com.xrc.kotlinproject.base.IBaseView

/**
 * MainContract
 * Created by xrc on 18/10/23.
 */
interface MainContract {

    interface View : IBaseView {

        fun loginSuccess()

        fun loginError()
    }

    interface Presenter : IBasePresenter {
        fun login(username: String, password: String)
    }

}