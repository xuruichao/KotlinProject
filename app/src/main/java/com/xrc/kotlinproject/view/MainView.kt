package com.xrc.kotlinproject.view

import com.xrc.kotlinproject.base.IBaseView

/**
 * MainView
 * Created by xrc on 18/10/15.
 */
interface MainView : IBaseView {

    fun loginSuccess()

    fun loginError()
}