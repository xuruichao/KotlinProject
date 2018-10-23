package com.xrc.kotlinproject.presenter

import android.os.Handler
import com.xrc.kotlinproject.base.BasePresenter
import com.xrc.kotlinproject.base.ProjectApplication
import com.xrc.kotlinproject.util.ToastUtil

/**
 * MainPresenter
 * Created by xrc on 18/10/15.
 */
class MainPresenter(view: MainContract.View) : BasePresenter<MainContract.View>(view), MainContract.Presenter {

    override fun login(username: String, password: String) {
        mvpView?.showDialog()
        Handler().postDelayed({
            if (username == "123" && password == "456") {
                mvpView?.loginSuccess()
                mvpView?.loginError()
            } else {
                ToastUtil.showToast("账号密码错误")
            }
            mvpView?.dismissDialog()
        }, 2000)
    }
}