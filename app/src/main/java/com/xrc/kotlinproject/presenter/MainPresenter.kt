package com.xrc.kotlinproject.presenter

import com.xrc.kotlinproject.base.BasePresenter
import com.xrc.kotlinproject.util.ToastUtil
import com.xrc.kotlinproject.view.MainView

/**
 * MainPresenter
 * Created by xrc on 18/10/15.
 */
class MainPresenter(view: MainView) : BasePresenter<MainView>(view) {

    fun login(username: String, password: String) {
        mvpView?.showDialog()
        if (username == "123" && password == "456") {
            mvpView?.loginSuccess()
            mvpView?.loginError()
        } else {
            ToastUtil.showToast("账号密码错误")
        }
        mvpView?.dismissDialog()
    }
}