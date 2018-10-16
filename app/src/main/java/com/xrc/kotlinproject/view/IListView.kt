package com.xrc.kotlinproject.view

import com.xrc.kotlinproject.base.IBaseView

/**
 * IListView
 * Created by xrc on 18/10/16.
 */
interface IListView : IBaseView {
    fun success()
    fun failed()
    fun empty()
}