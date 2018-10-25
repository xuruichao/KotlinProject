package com.xrc.kotlinproject.base

import com.xrc.kotlinproject.bean.BaseMultiTypeBean

/**
 * BaseItem
 * Created by xrc on 18/10/25.
 */
abstract class BaseItem<out B : BaseMultiTypeBean> {

    abstract fun getTemplate(): String

    abstract fun getLayoutId(): Int
}