package com.xrc.kotlinproject

import android.util.Log
import com.xrc.kotlinproject.base.BaseActivity
import com.xrc.kotlinproject.presenter.MainPresenter
import com.xrc.kotlinproject.view.MainView

class MainActivity : BaseActivity<MainPresenter>(), MainView {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initPresenter(): MainPresenter {
        return MainPresenter(this)
    }

    override fun init() {
        mPresenter?.login("123", "123")
    }

    override fun showDialog() {
        Log.e("TAG", "showDialog")
    }

    override fun loginSuccess() {
        Log.e("TAG", "loginSuccess")
    }

    override fun loginError() {
        Log.e("TAG", "loginError")
    }

    override fun dismissDialog() {
        Log.e("TAG", "dismissDialog")
    }

}
