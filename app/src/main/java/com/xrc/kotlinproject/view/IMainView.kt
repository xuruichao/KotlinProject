package com.xrc.kotlinproject.view

import com.xrc.kotlinproject.base.IBaseView

/**
 * IMainView
 * Created by xrc on 18/10/15.
 */
interface IMainView : IBaseView {

    fun loginSuccess()

    fun loginError()
}